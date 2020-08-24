package launchcode.org.ebay.organizer.data;

import launchcode.org.ebay.organizer.models.Listing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Integer> {
}
