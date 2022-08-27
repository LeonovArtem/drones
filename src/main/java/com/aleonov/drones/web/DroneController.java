package com.aleonov.drones.web;

import com.aleonov.drones.data.dto.DroneRegistrationDto;
import com.aleonov.drones.data.dto.DroneResponseDto;
import com.aleonov.drones.data.mapper.DroneResponseMapper;
import com.aleonov.drones.service.drone.DroneFactory;
import com.aleonov.drones.service.drone.DroneInfoService;
import com.aleonov.drones.service.drone.load.DroneLoadService;
import com.aleonov.drones.data.dto.DroneLoadResponseDto;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("drone")
@Tag(name = "Drone")
@RequiredArgsConstructor
public class DroneController {
    private final DroneFactory droneFactory;
    private final DroneInfoService droneInfoService;
    private final DroneLoadService droneLoadService;
    private final DroneResponseMapper mapper;

    @Operation(description = "Get all drones")
    @GetMapping
    public Mono<List<DroneResponseDto>> getAll() {
        return Mono.just(droneInfoService.getAll());
    }

    @Operation(description = "Register Drone")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DroneResponseDto register(@Valid @RequestBody DroneRegistrationDto droneRegistrationDto) {
        return mapper
                .droneToDroneResponseDto(
                        droneFactory.create(droneRegistrationDto)
                );
    }

    @Operation(description = "Get drone by ID")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<DroneResponseDto>> getById(@PathVariable("id") Long id) {
        return Mono.justOrEmpty(droneInfoService.getById(id))
                .map(mapper::droneToDroneResponseDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Operation(description = "Get available drones for loading")
    @GetMapping(value = "available", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DroneResponseDto> getAvailableDrones() {
        return droneInfoService.getAvailableDronesForLoading();
    }

    @Operation(summary = "Load drone with medication")
    @ApiResponse(description = "Drone loaded")
    @GetMapping(value = "load/{droneId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DroneLoadResponseDto> loadMedication(@PathVariable("droneId") Long droneId, Long medicationId) {
        var response = new DroneLoadResponseDto();
        try {
            droneLoadService.loadMedication(droneId, medicationId);
            response.setMessage("Medication added successfully");

            return ResponseEntity.ok(response);
        } catch (BusinessRuleException e) {
            response.setMessage(e.getMessage());
        }

        return ResponseEntity.badRequest().body(response);
    }
}
