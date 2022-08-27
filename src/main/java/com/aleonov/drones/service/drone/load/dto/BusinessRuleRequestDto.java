package com.aleonov.drones.service.drone.load.dto;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.entity.Medicament;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessRuleRequestDto {
    private final Drone drone;
    private final Medicament medicament;
}
