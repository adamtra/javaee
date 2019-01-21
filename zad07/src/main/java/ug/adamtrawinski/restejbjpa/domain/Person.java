package ug.adamtrawinski.restejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import ug.adamtrawinski.restejbjpa.view.View;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "person.all", query = "SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.laptops l LEFT JOIN FETCH l.manufacturer m LEFT JOIN FETCH l.serialCode sc"),
        @NamedQuery(name = "person.findById", query = "SELECT p FROM Person p LEFT JOIN FETCH p.laptops l LEFT JOIN FETCH l.manufacturer m LEFT JOIN FETCH l.serialCode sc WHERE p.id = :id"),
        @NamedQuery(name = "person.getLaptops", query = "SELECT l FROM Person p LEFT JOIN p.laptops l LEFT JOIN FETCH l.manufacturer LEFT JOIN FETCH l.serialCode WHERE p.id = :id"),
        @NamedQuery(name = "person.delete.all", query = "DELETE FROM Person")
})
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    @JsonView(View.PersonSummaryWithRelations.class)
    private List<Laptop> laptops = new ArrayList<>();

    public Person() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addLaptop(Laptop laptop) {
        getLaptops().add(laptop);
        laptop.getOwners().add(this);
    }

    public void removeLaptop(Laptop laptop) {
        getLaptops().remove(laptop);
        laptop.getOwners().remove(this);
    }

    @ManyToMany(mappedBy = "owners")
    @JsonIgnore
    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
