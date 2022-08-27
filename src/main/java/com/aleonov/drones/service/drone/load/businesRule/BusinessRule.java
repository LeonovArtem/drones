package com.aleonov.drones.service.drone.load.businesRule;

import com.aleonov.drones.service.drone.load.businesRule.exception.BusinessRuleException;
import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;

public interface BusinessRule {
    void check(BusinessRuleRequestDto businessRuleRequestDto) throws BusinessRuleException;
}
