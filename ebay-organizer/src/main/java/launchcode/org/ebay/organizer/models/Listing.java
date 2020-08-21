package launchcode.org.ebay.organizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Listing {

    @Id
    @GeneratedValue
    private int id;
}
