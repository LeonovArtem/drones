package com.aleonov.drones.web;

import com.aleonov.drones.dto.DroneRegistrationDto;
import com.aleonov.drones.dto.DroneResponseDto;
import com.aleonov.drones.mapper.DroneResponseMapper;
import com.aleonov.drones.service.drone.DroneFactory;
import com.aleonov.drones.service.drone.DroneInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("drone")
@RequiredArgsConstructor
public class DroneController {
    private final DroneFactory droneFactory;
    private final DroneInfoService droneInfoService;
    private final DroneResponseMapper mapper;

    @GetMapping
    public Mono<List<DroneResponseDto>> getAll() {
        return Mono.just(droneInfoService.getAll());
    }

    @PostMapping
    public DroneResponseDto register(@Valid @RequestBody DroneRegistrationDto droneRegistrationDto) {
        return mapper
                .droneToDroneResponseDto(
                        droneFactory.create(droneRegistrationDto)
                );
    }

}