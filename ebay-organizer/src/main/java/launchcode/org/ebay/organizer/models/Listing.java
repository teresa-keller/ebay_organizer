package launchcode.org.ebay.organizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Listing {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private double price;
    private double shipping;

    public Listing() {
    }

    public Listing(String name, String description, double price, double shipping) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shipping = shipping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public int getId() {
        return id;
    }
}
