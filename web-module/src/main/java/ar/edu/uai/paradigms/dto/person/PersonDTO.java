package ar.edu.uai.paradigms.dto.person;

import ar.edu.uai.model.person.Person;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */
public class PersonDTO {

    private Integer id;

    private String name;
    private int age;
    private String padre = "";
    private List<String> hijos = new ArrayList<String>();

    @JsonCreator
    public PersonDTO(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPadre(){
        return this.padre;
    }

    public void setPadre(String padre){ this.padre = padre; }

    public List<String> getHijos(){ return this.hijos; }

    public void addHijo(String hijo){ this.hijos.add(hijo); }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
