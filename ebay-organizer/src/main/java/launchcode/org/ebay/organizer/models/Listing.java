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
    private String status;


    public Listing() {
    }

    public Listing(String name, String description, double price, double shipping) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shipping = shipping;
    }

    public String currentStatus() {

        if (this.status.equals("future")) {
            this.status = "Future";
        } else if (this.status.equals("current")) {
            this.status = "Currently Listed";
        } else if (this.status.equals("sold")) {
            this.status = "Sold";
        }
        return this.status;
    }

    public String updateStatus() {
        if (this.status.equals("future")) {
            this.status = "Future";
        } else if (this.status.equals("current")) {
            this.status = "Currently Listed";
        } else if (this.status.equals("sold")) {
            this.status = "Sold";
        }
        return this.status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
