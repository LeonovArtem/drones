package com.aleonov.drones.mapper;

import com.aleonov.drones.dto.MedicamentRegistrationDto;
import com.aleonov.drones.entity.Medicament;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicamentRegistrationMapper {
    Medicament medicamentDtoToMedicament(MedicamentRegistrationDto medicamentRegistrationDto);

    MedicamentRegistrationDto medicamentToMedicamentDto(Medicament medicament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Medicament updateMedicamentFromMedicamentDto(MedicamentRegistrationDto medicamentRegistrationDto, @MappingTarget Medicament medicament);
}
