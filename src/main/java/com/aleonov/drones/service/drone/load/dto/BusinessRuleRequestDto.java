package com.aleonov.drones.service.drone.load.dto;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.entity.Medicament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BusinessRuleRequestDto {
    private Drone drone;
    private Medicament medicament;
}
