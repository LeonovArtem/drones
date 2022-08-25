package com.aleonov.drones.service.drone.impl;

import com.aleonov.drones.dto.DroneResponseDto;
import com.aleonov.drones.mapper.DroneResponseMapper;
import com.aleonov.drones.repository.DroneRepository;
import com.aleonov.drones.service.drone.DroneInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneInfoServiceImpl implements DroneInfoService {
    private final DroneRepository repository;
    private final DroneResponseMapper mapper;

    @Override
    public List<DroneResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::droneToDroneResponseDto)
                .toList();
    }

}
