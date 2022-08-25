package com.aleonov.drones.mapper;

import com.aleonov.drones.dto.DroneResponseDto;
import com.aleonov.drones.entity.Drone;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DroneResponseMapper {
    Drone droneResponseDtoToDrone(DroneResponseDto droneResponseDto);

    DroneResponseDto droneToDroneResponseDto(Drone drone);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Drone updateDroneFromDroneResponseDto(DroneResponseDto droneResponseDto, @MappingTarget Drone drone);
}
