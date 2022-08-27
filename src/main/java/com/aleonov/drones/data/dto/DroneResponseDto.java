package com.aleonov.drones.data.dto;

import com.aleonov.drones.data.entity.Drone;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DroneResponseDto implements Serializable {
    private final Long id;
    private final String serialNumber;
    private final Drone.Model model;
    private final Integer weightLimit;
    private final Integer batteryCapacity;
    private final Drone.State state;
    private final List<MedicamentResponseDto> medications;
}
