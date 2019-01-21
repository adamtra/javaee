package ug.adamtrawinski.restejbjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import ug.adamtrawinski.restejbjpa.view.View;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "laptop.findById", query = "SELECT l FROM Laptop l LEFT JOIN FETCH l.manufacturer m LEFT JOIN FETCH l.serialCode sc LEFT JOIN FETCH l.owners WHERE l.id = :id"),
        @NamedQuery(name = "laptop.findByNameLike", query = "SELECT l FROM Laptop l WHERE LOWER(l.name) LIKE LOWER(CONCAT('%', :name, '%'))"),
        @NamedQuery(name = "laptop.findPriceBetween", query = "SELECT l FROM Laptop l WHERE l.price >= :min AND l.price <= :max"),
        @NamedQuery(name = "laptop.findBySerialCode", query = "SELECT l FROM Laptop l JOIN l.serialCode sc WHERE sc.code = :code"),
        @NamedQuery(name = "laptop.findByManufacturer", query = "SELECT l FROM Laptop l JOIN l.manufacturer m WHERE m.name = :manufacturer"),
        @NamedQuery(name = "laptop.delete.all", query = "DELETE FROM Laptop")
})
public class Laptop {
    @JsonView(View.LaptopSummary.class)
    private long id;
    @JsonView(View.LaptopSummary.class)
    private String name;
    @JsonView(View.LaptopSummary.class)
    private boolean used;
    @JsonView(View.LaptopSummary.class)
    private double price;
    @JsonView(View.LaptopSummary.class)
    private Date releaseDate;
    @JsonView({View.LaptopSummaryWithRelations.class, View.PersonSummaryWithRelations.class})
    private Manufacturer manufacturer;
    @JsonView(View.LaptopSummaryWithRelations.class)
    private List<Person> owners;
    @JsonView({View.LaptopSummaryWithRelations.class, View.PersonSummaryWithRelations.class})
    private SerialCode serialCode;

    public Laptop() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    public void addOwner(Person owner) {
        getOwners().add(owner);
        owner.getLaptops().add(this);
    }

    public void removeOwner(Person owner) {
        getOwners().remove(owner);
        owner.getLaptops().remove(this);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @OneToOne(fetch = FetchType.LAZY)
    public SerialCode getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(SerialCode serialCode) {
        this.serialCode = serialCode;
    }
}
