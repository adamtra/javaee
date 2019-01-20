package ug.adamtrawinski.restejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "person.all", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "person.delete.all", query = "DELETE FROM Person")
})
public class Person {
    private long id;
    private String firstName;
    private String lastName;
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

//    public void addLaptop(Laptop laptop) {
//        getLaptops().add(laptop);
//        laptop.getOwners().add(this);
//    }
//
//    public void removeLaptop(Laptop laptop) {
//        getLaptops().remove(laptop);
//        laptop.getOwners().remove(this);
//    }

    @ManyToMany(mappedBy = "owners")
    @JsonIgnore
    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
}
