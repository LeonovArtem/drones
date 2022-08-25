package com.aleonov.drones.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MedicamentResponseDto implements Serializable {
    private final Long id;
    private final String name;
    private final Integer weight;
    private final String code;
    private final String imageUrl;
}
