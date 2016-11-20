package ar.edu.uai.model.person;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Access(AccessType.FIELD)
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private Integer age;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name="PADRE")
    private Person padre;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "padre", targetEntity = Person.class)
    private List<Person> hijos;




    public Person() {
        this.hijos = new ArrayList<Person>();
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hijos = new ArrayList<Person>();
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

    public void setPadre(Person padre){
        this.padre = padre;
    }

    public Person getPadre(){return this.padre;}

    public List<Person> getHijos() { return this.hijos; }

    public void addHijo(Person hijo){
        if(hijo != null){

            if(!this.getHijos().contains(hijo)){
                this.getHijos().add(hijo);
                //hijo.setPadre(this);
            }

        }
    }



    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
