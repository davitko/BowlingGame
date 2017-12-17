package netgloo.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import netgloo.models.City;


/**
 * 
 * @author Miloš Davitković
 *
 */
@Transactional
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
	
	List<City> findByName(String name);
	City findByServerid(Double serverid);
	List<City> findByCountry(String country);
	List<City> findByLongitude(Double longitude);
	List<City> findByLatitude(Double latitude);
	List<City> findByDeleted(Boolean deleted);
	
}
