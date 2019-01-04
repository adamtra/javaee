package ug.adamtrawinski.restejbjpa.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "manufacturer.delete.all", query = "DELETE FROM Manufacturer")
})
public class Manufacturer {
    private long id;
    private String name;
    private int operateSince;

    public Manufacturer() {

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

    public int getOperateSince() {
        return operateSince;
    }

    public void setOperateSince(int operateSince) {
        this.operateSince = operateSince;
    }
}
