package com.aleonov.drones.service.drone;

import com.aleonov.drones.data.dto.DroneRegistrationDto;
import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.mapper.DroneRegistrationMapper;
import com.aleonov.drones.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DroneFactory {
    private final DroneRepository repository;
    private final DroneRegistrationMapper droneRegistrationMapper;

    public Drone create(DroneRegistrationDto droneRegistrationDto) {
        var drone = droneRegistrationMapper.droneDtoToDrone(droneRegistrationDto);
        drone.setState(Drone.State.IDLE);
        repository.save(drone);

        return drone;
    }
}
