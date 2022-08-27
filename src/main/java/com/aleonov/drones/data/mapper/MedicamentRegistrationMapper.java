package com.aleonov.drones.data.mapper;

import com.aleonov.drones.data.dto.MedicamentRegistrationDto;
import com.aleonov.drones.data.entity.Medicament;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicamentRegistrationMapper {
    Medicament medicamentDtoToMedicament(MedicamentRegistrationDto medicamentRegistrationDto);

    MedicamentRegistrationDto medicamentToMedicamentDto(Medicament medicament);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Medicament updateMedicamentFromMedicamentDto(MedicamentRegistrationDto medicamentRegistrationDto, @MappingTarget Medicament medicament);
}
