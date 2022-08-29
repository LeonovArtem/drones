package com.aleonov.drones.service.drone.load.businesRule.exception;

import com.aleonov.drones.data.entity.Drone;

public class DroneAcceptableStateException extends BusinessRuleException {
    public DroneAcceptableStateException(Drone.State droneState) {
        super(
                String.format(
                        "Drone must be in active states! Current state: %s; AcceptableStates: %s",
                        droneState,
                        Drone.State.getActiveStates()
                )
        );
    }
}
