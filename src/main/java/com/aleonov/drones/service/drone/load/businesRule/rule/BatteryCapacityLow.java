package com.aleonov.drones.service.drone.load.businesRule.rule;

import com.aleonov.drones.service.drone.load.businesRule.BusinessRule;
import com.aleonov.drones.service.drone.load.businesRule.exception.BatteryLowException;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import org.springframework.stereotype.Service;

@Service
public class BatteryCapacityLow implements BusinessRule {
    private static final Integer MINIMAL_BATTERY_CAPACITY = 25;

    @Override
    public void check(BusinessRuleRequestDto requestDto) throws BusinessRuleException {
        if (requestDto.getDrone().getBatteryCapacity() < MINIMAL_BATTERY_CAPACITY) {
            throw new BatteryLowException(
                    String.format("Battery capacity can not be less %d", MINIMAL_BATTERY_CAPACITY)
            );
        }
    }
}
