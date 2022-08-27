package com.aleonov.drones.service.drone;

import com.aleonov.drones.data.dto.DroneResponseDto;
import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.mapper.DroneResponseMapper;
import com.aleonov.drones.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Drone> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DroneResponseDto> getAvailableDronesForLoading() {
        return repository.findByStateIsIn(Drone.State.getActiveStates())
                .stream()
                .map(mapper::droneToDroneResponseDto)
                .toList();
    }
}
