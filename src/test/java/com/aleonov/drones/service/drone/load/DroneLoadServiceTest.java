package com.aleonov.drones.service.drone.load;

import com.aleonov.drones.BaseFunctionalTest;
import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.entity.Medicament;
import com.aleonov.drones.repository.DroneRepository;
import com.aleonov.drones.repository.MedicamentRepository;
import com.aleonov.drones.service.drone.load.businesRule.exception.BatteryLowException;
import com.aleonov.drones.service.drone.load.businesRule.exception.DroneAcceptableStateException;
import com.aleonov.drones.service.drone.load.businesRule.exception.WeightLimitException;
import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class DroneLoadServiceTest extends BaseFunctionalTest {
    @Autowired
    private DroneLoadService droneLoadService;

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Test
    @DataSet(
            value = {"/dataSet/drone/load/drone_state_is_not_active_dataset.json"}
    )
    @Transactional
    public void whenDroneStateIsNotActive_thenMedicationNotAdd() {
        var droneId = 1L;
        var medicationId = 1L;
        var droneBeforeLoaded = getDrone(droneId);

        Assertions.assertThrowsExactly(
                DroneAcceptableStateException.class,
                () -> droneLoadService.loadMedication(droneId, medicationId)
        );

        var droneAfterLoaded = getDrone(droneId);
        assertDroneIsNotChange(droneBeforeLoaded, droneAfterLoaded);
    }

    @Test
    @DataSet(
            value = {"/dataSet/drone/load/drone_state_is_active_dataset.json"}
    )
    @Transactional
    public void whenDroneStateIsActive_thenMedicationIsLoaded() {
        var droneId = 1L;
        var medicationId = 1L;
        droneLoadService.loadMedication(droneId, medicationId);

        var droneAfterLoaded = getDrone(droneId);
        var medication = getMedicament(medicationId);
        assertMedicationIsLoadedForDrone(droneAfterLoaded, medication);

        Assertions.assertEquals(droneAfterLoaded.getState(), Drone.State.LOADING);
    }

    @Test
    @DataSet(
            value = {"/dataSet/drone/load/drone_battery_low_dataset.json"}
    )
    @Transactional
    public void whenDroneBatteryLow_thenMedicationIsNotLoaded() {
        var droneId = 1L;
        var medicationId = 1L;
        var droneBeforeLoaded = getDrone(droneId);

        Assertions.assertThrowsExactly(
                BatteryLowException.class,
                () -> droneLoadService.loadMedication(droneId, medicationId)
        );

        var droneAfterLoaded = getDrone(droneId);
        assertDroneIsNotChange(droneBeforeLoaded, droneAfterLoaded);
    }

    @Test
    @DataSet(
            value = {"/dataSet/drone/load/drone_weight_limit_dataset.json"}
    )
    @Transactional
    public void whenDroneWeightLimitReached_thenMedicationIsNotLoaded() {
        var droneId = 1L;
        var medicationId = 3L;
        var droneBeforeLoaded = getDrone(droneId);

        Assertions.assertThrowsExactly(
                WeightLimitException.class,
                () -> droneLoadService.loadMedication(droneId, medicationId)
        );

        var droneAfterLoaded = getDrone(droneId);
        assertDroneIsNotChange(droneBeforeLoaded, droneAfterLoaded);
    }

    private void assertDroneIsNotChange(Drone droneBeforeLoaded, Drone droneAfterLoaded) {
        Assertions.assertEquals(
                droneBeforeLoaded.getMedications().size(),
                droneAfterLoaded.getMedications().size()
        );
        Assertions.assertEquals(
                droneBeforeLoaded.getState(),
                droneAfterLoaded.getState()
        );
    }

    private void assertMedicationIsLoadedForDrone(Drone drone, Medicament medicament) {
        Assertions.assertTrue(
                drone.getMedications().contains(medicament)
        );
    }

    private Drone getDrone(Long id) {
        return droneRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    private Medicament getMedicament(Long id) {
        return medicamentRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
