package com.aleonov.drones.service.drone.load.dto;

import lombok.Data;

@Data
public class DroneLoadRequestDto {
    private final Long droneId;
    private final Long medicationId;
}
