package com.aleonov.drones.data.mapper;

import com.aleonov.drones.data.dto.MedicamentResponseDto;
import com.aleonov.drones.data.entity.Medicament;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicamentResponseMapper {
    Medicament medicamentResponseDtoToMedicament(MedicamentResponseDto medicamentResponseDto);

    MedicamentResponseDto medicamentToMedicamentResponseDto(Medicament medicament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Medicament updateMedicamentFromMedicamentResponseDto(MedicamentResponseDto medicamentResponseDto, @MappingTarget Medicament medicament);
}
