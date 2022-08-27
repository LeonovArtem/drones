package com.aleonov.drones.data.mapper;

import com.aleonov.drones.data.entity.Drone;
import com.aleonov.drones.data.dto.DroneResponseDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DroneResponseMapper {
    Drone droneResponseDtoToDrone(DroneResponseDto droneResponseDto);

    DroneResponseDto droneToDroneResponseDto(Drone drone);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Drone updateDroneFromDroneResponseDto(DroneResponseDto droneResponseDto, @MappingTarget Drone drone);
}
