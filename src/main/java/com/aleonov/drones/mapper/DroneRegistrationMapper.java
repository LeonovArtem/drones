package com.aleonov.drones.mapper;

import com.aleonov.drones.dto.DroneRegistrationDto;
import com.aleonov.drones.entity.Drone;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DroneRegistrationMapper {
    Drone droneDtoToDrone(DroneRegistrationDto droneRegistrationDto);

    DroneRegistrationDto droneToDroneDto(Drone drone);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Drone updateDroneFromDroneDto(DroneRegistrationDto droneRegistrationDto, @MappingTarget Drone drone);
}
