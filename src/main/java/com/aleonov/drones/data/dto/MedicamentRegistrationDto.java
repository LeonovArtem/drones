package com.aleonov.drones.data.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
public class MedicamentRegistrationDto implements Serializable {

    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "name: Allowed only letters, numbers, ‘-‘, ‘_’")
    private final String name;

    @Positive(message = "Weight must be positive")
    private final Integer weight;

    @Pattern(regexp = "^[A-Z0-9_]*$", message = "code: Allowed only upper case letters, underscore and numbers")
    private final String code;

    private final String imageUrl;
}
