package com.aleonov.drones.repository;

import com.aleonov.drones.data.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByStateIsIn(List<Drone.State> droneStates);
}
