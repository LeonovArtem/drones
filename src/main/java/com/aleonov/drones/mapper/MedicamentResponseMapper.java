package com.aleonov.drones.mapper;

import com.aleonov.drones.dto.MedicamentResponseDto;
import com.aleonov.drones.entity.Medicament;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicamentResponseMapper {
    Medicament medicamentResponseDtoToMedicament(MedicamentResponseDto medicamentResponseDto);

    MedicamentResponseDto medicamentToMedicamentResponseDto(Medicament medicament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Medicament updateMedicamentFromMedicamentResponseDto(MedicamentResponseDto medicamentResponseDto, @MappingTarget Medicament medicament);
}
