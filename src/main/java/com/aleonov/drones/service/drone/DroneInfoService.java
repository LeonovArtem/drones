package com.aleonov.drones.service.drone;

import com.aleonov.drones.data.dto.DroneResponseDto;
import com.aleonov.drones.data.entity.Drone;

import java.util.List;
import java.util.Optional;

public interface DroneInfoService {
    List<DroneResponseDto> getAll();

    Optional<Drone> getById(Long id);

    List<DroneResponseDto> getAvailableDronesForLoading();
}
