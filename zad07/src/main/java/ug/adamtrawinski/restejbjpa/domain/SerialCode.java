package ug.adamtrawinski.restejbjpa.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "serialCode.all", query = "SELECT sc FROM SerialCode sc"),
        @NamedQuery(name = "serialCode.delete.all", query = "DELETE FROM SerialCode")
})
public class SerialCode {
    private long id;
    private String code;


    public SerialCode() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
