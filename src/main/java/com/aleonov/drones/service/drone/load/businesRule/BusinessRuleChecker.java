package com.aleonov.drones.service.drone.load.businesRule;

import com.aleonov.drones.service.drone.load.dto.BusinessRuleRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessRuleChecker {
    private final List<BusinessRule> businessRules;

    public void check(BusinessRuleRequestDto businessRuleRequestDto) {
        businessRules.forEach(businessRule -> businessRule.check(businessRuleRequestDto));
    }
}
