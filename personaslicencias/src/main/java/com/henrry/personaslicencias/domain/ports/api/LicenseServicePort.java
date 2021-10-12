package com.henrry.personaslicencias.domain.ports.api;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.domain.ports.BasePort;


public interface LicenseServicePort extends BasePort<LicenseDTO> {
    String createLicenseNumber();
}
