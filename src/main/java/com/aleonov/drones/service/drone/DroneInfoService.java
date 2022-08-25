package com.aleonov.drones.service.drone;

import com.aleonov.drones.dto.DroneResponseDto;

import java.util.List;

public interface DroneInfoService {
    List<DroneResponseDto> getAll();
}
