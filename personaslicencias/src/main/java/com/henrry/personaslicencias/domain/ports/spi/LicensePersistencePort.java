package com.henrry.personaslicencias.domain.ports.spi;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.domain.ports.BasePort;

public interface LicensePersistencePort extends BasePort<LicenseDTO> {
    String createLicenseNumber();
}
