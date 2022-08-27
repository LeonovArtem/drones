package com.aleonov.drones.service.drone.load.businesRule.rule;

import com.aleonov.drones.service.drone.load.businesRule.BusinessRule;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import org.springframework.stereotype.Service;

@Service
public class DroneMedication implements BusinessRule {
    @Override
    public void check(BusinessRuleRequestDto requestDto) throws BusinessRuleException {
        var drone = requestDto.getDrone();

        if (drone.getMedications().contains(requestDto.getMedicament())) {
            throw new BusinessRuleException(
                    String.format(
                            "Medication with id: %d already added",
                            requestDto.getMedicament().getId()
                    )
            );
        }
    }
}
