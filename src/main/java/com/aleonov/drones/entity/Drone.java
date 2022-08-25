package com.aleonov.drones.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private Model model;

    private Integer weightLimit;

    private Integer batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    public enum Model {
        LIGHTWEIGHT,
        MIDDLEWEIGHT,
        CRUISERWEIGHT,
        HEAVYWEIGHT,
    }

    public enum State {
        IDLE,
        LOADING,
        LOADED,
        DELIVERING,
        DELIVERED,
        RETURNING,
    }
}
