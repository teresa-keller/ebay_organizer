package launchcode.org.ebay.organizer.repositories;

import launchcode.org.ebay.organizer.models.Information;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends CrudRepository<Information, Integer> {
}
