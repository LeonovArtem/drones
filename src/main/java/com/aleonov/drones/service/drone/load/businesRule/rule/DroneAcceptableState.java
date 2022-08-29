package com.aleonov.drones.service.drone.load.businesRule.rule;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.service.drone.load.businesRule.BusinessRule;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.businesRule.exception.DroneAcceptableStateException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import org.springframework.stereotype.Service;

@Service
public class DroneAcceptableState implements BusinessRule {
    @Override
    public void check(BusinessRuleRequestDto requestDto) throws BusinessRuleException {
        var droneState = requestDto.getDrone().getState();
        if (!Drone.State.getActiveStates().contains(droneState)) {
            throw new DroneAcceptableStateException(droneState);
        }
    }
}
