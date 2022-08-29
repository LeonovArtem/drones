package com.aleonov.drones.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "medicament")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer weight;

    private String code;

    private String imageUrl;
}
