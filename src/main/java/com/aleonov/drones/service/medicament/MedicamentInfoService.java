package com.aleonov.drones.service.medicament;

import com.aleonov.drones.dto.MedicamentResponseDto;

import java.util.List;

public interface MedicamentInfoService {
    List<MedicamentResponseDto> getAll();
}
