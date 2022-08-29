package com.aleonov.drones.service.drone.load.businesRule.rule;

import com.aleonov.drones.data.entity.Medicament;
import com.aleonov.drones.service.drone.load.businesRule.BusinessRule;
import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.businesRule.exception.WeightLimitException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import org.springframework.stereotype.Service;

@Service
public class WeightLimit implements BusinessRule {
    @Override
    public void check(BusinessRuleRequestDto requestDto) throws BusinessRuleException {
        var drone = requestDto.getDrone();
        var currentDroneMedicationWeight = drone.getMedications()
                .stream()
                .mapToInt(Medicament::getWeight)
                .sum();
        var totalWeight = currentDroneMedicationWeight + requestDto.getMedicament().getWeight();

        if (totalWeight > drone.getWeightLimit()) {
            throw new WeightLimitException(
                    new WeightLimitException.AdditionalInfoMessage(
                            currentDroneMedicationWeight,
                            drone.getWeightLimit(),
                            requestDto.getMedicament().getWeight()
                    )
            );
        }
    }
}
