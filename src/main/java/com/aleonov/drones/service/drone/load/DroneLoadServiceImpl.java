package com.aleonov.drones.service.drone.load;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.repository.DroneRepository;
import com.aleonov.drones.repository.MedicamentRepository;
import com.aleonov.drones.service.drone.DroneInfoService;
import com.aleonov.drones.service.drone.load.businesRule.BusinessRuleChecker;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DroneLoadServiceImpl implements DroneLoadService {
    private final BusinessRuleChecker businessRuleChecker;
    private final DroneInfoService droneInfoService;
    private final MedicamentRepository medicamentRepository;
    private final DroneRepository droneRepository;

    @Override
    @Transactional
    public void loadMedication(Long droneId, Long medicationId) throws BusinessRuleException {
        var drone = droneInfoService
                .getById(droneId)
                .orElseThrow(() -> new BusinessRuleException("Drone is not found"));
        var medication = medicamentRepository
                .findById(medicationId)
                .orElseThrow(() -> new BusinessRuleException("Medicament is not found"));

        businessRuleChecker.check(new BusinessRuleRequestDto(drone, medication));
        if (!drone.getState().equals(Drone.State.LOADING)) {
            drone.setState(Drone.State.LOADING);
        }
        drone.getMedications().add(medication);
        droneRepository.save(drone);
    }
}
