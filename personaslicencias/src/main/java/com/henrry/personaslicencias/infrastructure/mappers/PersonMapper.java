package com.henrry.personaslicencias.infrastructure.mappers;

import com.henrry.personaslicencias.domain.data.PersonDTO;
import com.henrry.personaslicencias.infrastructure.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> personListToPersonDTOList(List<Person> personList);

    List<Person> personDTOListToPersonList(List<PersonDTO> personDTOList);

}
