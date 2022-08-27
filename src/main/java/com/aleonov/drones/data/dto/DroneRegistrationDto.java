package com.aleonov.drones.data.dto;

import com.aleonov.drones.data.entity.Drone;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class DroneRegistrationDto implements Serializable {

    @Size(max = 100, message = "Max size of serial number can not be more 100 characters")
    private final String serialNumber;

    private final Drone.Model model;

    @Positive(message = "Weight limit must be positive")
    @Max(value = 500, message = "Weight limit can not be more 500gr")
    private final Integer weightLimit;

    @Positive(message = "Battery capacity must be positive")
    @Max(value = 100, message = "Battery capacity can not be more 100 percentage")
    private final Integer batteryCapacity;
}
