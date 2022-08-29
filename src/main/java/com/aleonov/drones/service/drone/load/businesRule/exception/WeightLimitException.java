package com.aleonov.drones.service.drone.load.businesRule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class WeightLimitException extends BusinessRuleException {
    private static final String MESSAGE = "Maximum drone weight has been reached!";

    public WeightLimitException() {
        super(MESSAGE);
    }

    public WeightLimitException(AdditionalInfoMessage additionalInfoMessage) {
        super(MESSAGE + additionalInfoMessage);
    }

    @Getter
    @AllArgsConstructor
    public static class AdditionalInfoMessage {
        private Integer droneMedicationsWeight;
        private Integer droneWeightLimit;
        private Integer medicationWeight;

        @Override
        public String toString() {
            return "AdditionalInfoMessage{" +
                    "droneMedicationsWeight=" + droneMedicationsWeight +
                    ", droneWeightLimit=" + droneWeightLimit +
                    ", medicationWeight=" + medicationWeight +
                    '}';
        }
    }
}
