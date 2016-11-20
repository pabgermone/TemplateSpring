package ar.edu.uai.paradigms.translator.person;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.model.person.PersonCriteria;
import ar.edu.uai.paradigms.dto.person.PersonCriteriaDTO;
import ar.edu.uai.paradigms.dto.person.PersonDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonTranslator {

    public Person translate(PersonDTO personDTO) {
        return new Person(personDTO.getId(), personDTO.getName(), personDTO.getAge());
    }

    public PersonDTO translateToDTO(Person person) {
        if (person != null){
            PersonDTO personDTO = new PersonDTO(person.getId(), person.getName(), person.getAge());

            if(person.getPadre() != null){
                personDTO.setPadre(person.getPadre().getName());
            }

            if(person.getHijos().size() > 0){
                for(Person hijo : person.getHijos()){
                    personDTO.addHijo(hijo.getName());
                }
            }

            return personDTO;
        }

        return null;
    }

    public List<PersonDTO> translateToDTO(List<Person> persons) {
        List<PersonDTO> personResponse = new ArrayList<PersonDTO>();
        for(Person p : persons) {
            PersonDTO personDTO = this.translateToDTO(p);
            if(personDTO != null) {
                personResponse.add(personDTO);
            }
        }
        return personResponse;
    }

    public PersonCriteria translateCriteria(PersonCriteriaDTO personCriteriaDTO) {
        return new PersonCriteria(personCriteriaDTO.getName(), personCriteriaDTO.getMinAge(), personCriteriaDTO.getMaxAge());
    }

}
