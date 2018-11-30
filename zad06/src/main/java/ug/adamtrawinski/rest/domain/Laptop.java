package ug.adamtrawinski.rest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Laptop {
    private long id = 0;
    private String name = "Lenovo";
    private boolean used = true;
    private double price = 1200.34;
    private Date releaseDate = new Date();

    public Laptop(long id, String name, boolean used, double price, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.used = used;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Laptop() {

    }

    public String showDetails() {
        String state;
        if(used) {
            state = "Użytany";
        }
        else {
            state = "Nowy";
        }
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        return "Nazwa: " + name + "<br>Stan: " + state + "<br>Cena: " + price + "<br>Data wydania: " + df.format(releaseDate);
    }

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

}
