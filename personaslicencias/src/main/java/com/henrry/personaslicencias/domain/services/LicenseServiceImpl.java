package com.henrry.personaslicencias.domain.services;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.domain.ports.api.LicenseServicePort;
import com.henrry.personaslicencias.domain.ports.spi.LicensePersistencePort;

import java.util.List;

public class LicenseServiceImpl implements LicenseServicePort {
    private LicensePersistencePort licensePersistencePort;

    public LicenseServiceImpl(LicensePersistencePort licensePersistencePort) {
        this.licensePersistencePort = licensePersistencePort;
    }

    @Override
    public LicenseDTO add(LicenseDTO licenseDTO) {
        return licensePersistencePort.add(licenseDTO);
    }

    @Override
    public void deleteById(Long id) {
        licensePersistencePort.deleteById(id);
    }

    @Override
    public LicenseDTO update(LicenseDTO licenseDTO) {
        return licensePersistencePort.update(licenseDTO);
    }

    @Override
    public List<LicenseDTO> getAll() {
        return licensePersistencePort.getAll();
    }

    @Override
    public LicenseDTO getById(Long id) {
        return licensePersistencePort.getById(id);
    }

    @Override
    public String createLicenseNumber() {
        return licensePersistencePort.createLicenseNumber();
    }
}
