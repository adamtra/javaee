package ug.adamtrawinski.javaee.sklep.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Laptop {
    private long id;
    private String name;
    private boolean used;
    private double price;
    private Date releaseDate;

    public String showDetails() {
        String stan;
        if(used) {
            stan = "Użytany";
        }
        else {
            stan = "Nowy";
        }
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        return "Nazwa: " + name + " Stan: " + stan + " Cena: " + price + " Data wydania: " + df.format(releaseDate);
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

}
