package com.aleonov.drones.service.drone;

import com.aleonov.drones.dto.DroneResponseDto;
import com.aleonov.drones.entity.Drone;

import java.util.List;
import java.util.Optional;

public interface DroneInfoService {
    List<DroneResponseDto> getAll();

    Optional<Drone> getById(Long id);

    List<DroneResponseDto> getAvailableDronesForLoading();
}
