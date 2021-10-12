package com.henrry.personaslicencias.domain.services;

import com.henrry.personaslicencias.domain.data.PersonDTO;
import com.henrry.personaslicencias.domain.ports.api.PersonServicePort;
import com.henrry.personaslicencias.domain.ports.spi.PersonPersistencePort;

import java.util.List;

public class PersonServiceImpl implements PersonServicePort {

    private PersonPersistencePort personPersistencePort;

    public PersonServiceImpl(PersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public PersonDTO add(PersonDTO personDTO) {
        return personPersistencePort.add(personDTO);
    }

    @Override
    public void deleteById(Long id) {
        personPersistencePort.deleteById(id);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return personPersistencePort.update(personDTO);
    }

    @Override
    public List<PersonDTO> getAll() {
        return personPersistencePort.getAll();
    }

    @Override
    public PersonDTO getById(Long id) {
        return personPersistencePort.getById(id);
    }
}
