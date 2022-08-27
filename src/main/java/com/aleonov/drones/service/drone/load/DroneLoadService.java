package com.aleonov.drones.service.drone.load;

import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;

public interface DroneLoadService {
    void loadMedication(Long droneId, Long medicationId) throws BusinessRuleException;
}
