package com.aleonov.drones.web;

import com.aleonov.drones.data.dto.MedicamentRegistrationDto;
import com.aleonov.drones.data.dto.MedicamentResponseDto;
import com.aleonov.drones.data.mapper.MedicamentResponseMapper;
import com.aleonov.drones.service.medicament.MedicamentFactory;
import com.aleonov.drones.service.medicament.MedicamentInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medication")
@Tag(name = "Medication")
@RequiredArgsConstructor
public class MedicamentController {
    private final MedicamentFactory medicamentFactory;
    private final MedicamentInfoService medicamentInfoService;
    private final MedicamentResponseMapper mapper;

    @Operation(description = "Get all medications")
    @GetMapping
    public List<MedicamentResponseDto> getAll() {
        return medicamentInfoService.getAll();
    }

    @Operation(description = "Create medication")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MedicamentResponseDto create(@Valid @RequestBody MedicamentRegistrationDto medicamentRegistrationDto) {
        return mapper
                .medicamentToMedicamentResponseDto(
                        medicamentFactory.create(medicamentRegistrationDto)
                );
    }

}
