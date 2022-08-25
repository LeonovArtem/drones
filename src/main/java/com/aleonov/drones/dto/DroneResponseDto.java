package com.aleonov.drones.dto;

import com.aleonov.drones.entity.Drone;
import lombok.Data;

import java.io.Serializable;

@Data
public class DroneResponseDto implements Serializable {
    private final Long id;
    private final String serialNumber;
    private final Drone.Model model;
    private final Integer weightLimit;
    private final Integer batteryCapacity;
    private final Drone.State state;
}
