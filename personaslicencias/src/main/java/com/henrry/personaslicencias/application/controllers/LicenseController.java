package com.henrry.personaslicencias.application.controllers;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.domain.data.PersonDTO;
import com.henrry.personaslicencias.domain.ports.api.LicenseServicePort;
import com.henrry.personaslicencias.domain.ports.api.PersonServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license")
public class LicenseController {

    @Autowired
    private LicenseServicePort licenseServicePort;
    @Autowired
    private PersonServicePort personServicePort;

    @GetMapping("/get")
    public List<LicenseDTO> allLicenses() {
        return licenseServicePort.getAll();
    }

    @GetMapping("/get/{id}")
    public LicenseDTO getLicenseById(@PathVariable("id") Long id) {
        return licenseServicePort.getById(id);
    }

    @PostMapping("/add/{personId}")
    public LicenseDTO addLicense(@RequestBody LicenseDTO licenseDTO, @PathVariable("personId") Long personId) {
        PersonDTO person = personServicePort.getById(personId);
        String licenseNumber = licenseServicePort.createLicenseNumber();
        licenseDTO.setNumber(licenseNumber);
        licenseDTO.setPersonDTO(person);
        return licenseServicePort.add(licenseDTO);
    }

    @PutMapping("/update")
    public LicenseDTO updateLicense(@RequestBody LicenseDTO licenseDTO) {
        return licenseServicePort.update(licenseDTO);
    }
}
