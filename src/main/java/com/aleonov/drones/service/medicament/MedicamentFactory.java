package com.aleonov.drones.service.medicament;

import com.aleonov.drones.dto.MedicamentRegistrationDto;
import com.aleonov.drones.entity.Medicament;
import com.aleonov.drones.mapper.MedicamentRegistrationMapper;
import com.aleonov.drones.repository.MedicamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicamentFactory {
    private final MedicamentRepository medicamentRepository;
    private final MedicamentRegistrationMapper mapper;

    public Medicament create(MedicamentRegistrationDto medicamentRegistrationDto) {
        var medicament = mapper.medicamentDtoToMedicament(medicamentRegistrationDto);
        medicamentRepository.save(medicament);

        return medicament;
    }
}
