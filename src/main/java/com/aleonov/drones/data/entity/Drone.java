package com.aleonov.drones.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "drone_medicament",
            joinColumns = @JoinColumn(name = "drone_id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id")
    )
    private Set<Medicament> medications;

    public enum Model {
        LIGHTWEIGHT,
        MIDDLEWEIGHT,
        CRUISERWEIGHT,
        HEAVYWEIGHT;
    }

    public enum State {
        IDLE,
        LOADING,
        LOADED,
        DELIVERING,
        DELIVERED,
        RETURNING;

        public static List<State> getActiveStates() {
            return List.of(IDLE, LOADING);
        }
    }
}
