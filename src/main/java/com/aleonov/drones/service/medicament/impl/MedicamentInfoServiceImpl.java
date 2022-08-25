package com.aleonov.drones.service.medicament.impl;

import com.aleonov.drones.dto.MedicamentResponseDto;
import com.aleonov.drones.mapper.MedicamentResponseMapper;
import com.aleonov.drones.repository.MedicamentRepository;
import com.aleonov.drones.service.medicament.MedicamentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentInfoServiceImpl implements MedicamentInfoService {
    private final MedicamentRepository medicamentRepository;
    private final MedicamentResponseMapper mapper;

    @Override
    public List<MedicamentResponseDto> getAll() {
        return medicamentRepository.findAll()
                .stream()
                .map(mapper::medicamentToMedicamentResponseDto)
                .toList();
    }

}
