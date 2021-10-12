package com.henrry.personaslicencias.infrastructure.adapters;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.domain.ports.spi.LicensePersistencePort;
import com.henrry.personaslicencias.infrastructure.entity.License;
import com.henrry.personaslicencias.infrastructure.mappers.LicenseMapper;
import com.henrry.personaslicencias.infrastructure.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseJpaAdapter implements LicensePersistencePort {
    public static int licenseNumber;

    @Autowired
    private LicenseRepository licenseRepository;


    @Override
    public LicenseDTO add(LicenseDTO licenseDTO) {
        License license = LicenseMapper.INSTANCE.licenseDTOToLicense(licenseDTO);
        License licenseSaved = licenseRepository.save(license);
        return LicenseMapper.INSTANCE.licenseToLicenseDTO(licenseSaved);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public LicenseDTO update(LicenseDTO licenseDTO) {
        return add(licenseDTO);
    }

    @Override
    public List<LicenseDTO> getAll() {
        List<License> licenses = (List<License>) licenseRepository.findAll();
        return LicenseMapper.INSTANCE.licenseListToLicenseDTOList(licenses);
    }

    @Override
    public LicenseDTO getById(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return LicenseMapper.INSTANCE.licenseToLicenseDTO(optionalLicense.get());
        }

        return null;
    }

    // esta funcion añade los ceros al numero de la licencia
    public String formatStringNumber(int number) {
        String formato = String.format("%06d", number);
        return formato;
    }

    public String createLicenseNumber() {
        if(licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
            licenseNumber += 1;
            return formatStringNumber(licenseNumber);
        } else {
            List<License> topLicenseNumber = licenseRepository.findTopByOrderByNumberDesc();
            licenseNumber = Integer.parseInt(topLicenseNumber.get(0).getNumber()) + 1;
            return formatStringNumber(licenseNumber);
        }
    }

}
