package com.henrry.personaslicencias.application.controllers;

import com.henrry.personaslicencias.domain.data.PersonDTO;
import com.henrry.personaslicencias.domain.ports.api.PersonServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServicePort personServicePort;

    @PostMapping("/add")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personServicePort.add(personDTO);
    }

    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable("id") Long id) {
        return personServicePort.getById(id);
    }

    @PutMapping("/update")
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return personServicePort.update(personDTO);
    }

    @GetMapping("/get")
    public List<PersonDTO> allPersons() {
        return personServicePort.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personServicePort.deleteById(id);
    }
}
