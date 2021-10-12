package com.henrry.personaslicencias.infrastructure.adapters;

import com.henrry.personaslicencias.domain.data.PersonDTO;
import com.henrry.personaslicencias.domain.ports.spi.PersonPersistencePort;
import com.henrry.personaslicencias.infrastructure.entity.Person;
import com.henrry.personaslicencias.infrastructure.mappers.PersonMapper;
import com.henrry.personaslicencias.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonJpaAdapter implements PersonPersistencePort {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonDTO add(PersonDTO personDTO) {

        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        Person personSaved = personRepository.save(person);

        return PersonMapper.INSTANCE.personToPersonDTO(personSaved);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        return add(personDTO);
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> persons = (List<Person>) personRepository.findAll();

        return PersonMapper.INSTANCE.personListToPersonDTOList(persons);
    }

    @Override
    public PersonDTO getById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            return PersonMapper.INSTANCE.personToPersonDTO(person.get());
        }
        return null;
    }
}
