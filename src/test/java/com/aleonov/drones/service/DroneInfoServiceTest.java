package com.aleonov.drones.service;

import com.aleonov.drones.BaseFunctionalTest;
import com.aleonov.drones.entity.Drone;
import com.aleonov.drones.service.drone.DroneInfoService;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DroneInfoServiceTest extends BaseFunctionalTest {

    @Autowired
    private DroneInfoService droneInfoService;

    @Test
    @DataSet(
            value = {"/dataSet/drone/available/drone_with_all_state_dataset.json"}
    )
    void getAvailableDrones_mustBeReturnOnlyActiveDrone() {
        var availableDrones = droneInfoService.getAvailableDronesForLoading();
        var expectedCountDrones = 2;
        Assertions.assertEquals(expectedCountDrones, availableDrones.size());

        availableDrones.forEach(droneResponseDto -> {
            Assertions.assertTrue(
                    Drone.State.getActiveStates().contains(droneResponseDto.getState())
            );
        });
    }
}
