package com.aleonov.drones.web;

import com.aleonov.drones.dto.MedicamentRegistrationDto;
import com.aleonov.drones.dto.MedicamentResponseDto;
import com.aleonov.drones.mapper.MedicamentResponseMapper;
import com.aleonov.drones.service.medicament.MedicamentFactory;
import com.aleonov.drones.service.medicament.MedicamentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medicament")
@RequiredArgsConstructor
public class MedicamentController {
    private final MedicamentFactory medicamentFactory;
    private final MedicamentInfoService medicamentInfoService;
    private final MedicamentResponseMapper mapper;

    @GetMapping
    public List<MedicamentResponseDto> getAll() {
        return medicamentInfoService.getAll();
    }

    @PostMapping
    public MedicamentResponseDto create(@Valid @RequestBody MedicamentRegistrationDto medicamentRegistrationDto) {
        return mapper
                .medicamentToMedicamentResponseDto(
                        medicamentFactory.create(medicamentRegistrationDto)
                );
    }

}
