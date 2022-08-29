package com.aleonov.drones.cron;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.repository.DroneRepository;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.businesRule.rule.BatteryCapacityLow;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CheckDroneBatteryLevel {
    private final BatteryCapacityLow batteryCapacityChecker;
    private final DroneRepository droneRepository;

    @Scheduled(fixedDelayString = "PT1M")
    public void process() {
        log.info("Starting checking battery level for drone");
        droneRepository.findAll().forEach(this::checkBatteryLevel);
        log.info("Finishing checking battery level");
    }

    private void checkBatteryLevel(Drone drone) {
        try {
            batteryCapacityChecker.check(
                    BusinessRuleRequestDto
                            .builder()
                            .drone(drone)
                            .build()
            );
            log.info(
                    "Battery capacity is normal! DroneId:{}; BatteryLevel:{}",
                    drone.getId(),
                    drone.getBatteryCapacity()
            );
        } catch (BusinessRuleException e) {
            log.warn(
                    "DroneId: {}: Battery lowed! BatteryLevel: {} message:{}",
                    drone.getId(),
                    drone.getBatteryCapacity(),
                    e.getMessage()
            );
        }
    }
}
