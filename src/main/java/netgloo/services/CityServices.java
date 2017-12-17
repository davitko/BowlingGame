package netgloo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.com.java.Array.ArrayFn;
import netgloo.models.City;

import netgloo.repository.CityRepository;

@Service
@RequestMapping("/city")
public class CityServices {

	@Autowired
	ArrayFn arrayFn;
	@Autowired
	CityRepository cityRepository;


	public CityServices() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping("/all")
	@ResponseBody
	public List<City> findAll() {
		List<City> listOfAll = new ArrayList<City>();
		listOfAll = arrayFn.IterableToList(cityRepository.findAll());
		return listOfAll;
	}

	/**
	 * Find all city which is not Soft deleted
	 * @return
	 */
	@RequestMapping("/allSoft")
	@ResponseBody
	public List<City> findAllSoft() {
		List<City> listOfAll = new ArrayList<City>();
		listOfAll = arrayFn.IterableToList(cityRepository.findAll());
		List<City> result = new ArrayList<City>();
		for (City ct : listOfAll) {
			if (!ct.getDeleted()) {
				result.add(ct);
			}
		}
		return result;
	}

	@RequestMapping("/Count")
	@ResponseBody
	public Integer count() {
		List<City> listOfAll = new ArrayList<City>();
		listOfAll = arrayFn.IterableToList(cityRepository.findAll());
		return listOfAll.size();
	}

	@RequestMapping("/getLast")
	@ResponseBody
	public City getLast() {
		List<City> listOfAll = new ArrayList<City>();
		listOfAll = arrayFn.IterableToList(cityRepository.findAll());
		City lastCity = listOfAll.get(listOfAll.size() - 1);
		return lastCity;
	}

	@RequestMapping("/id")
	@ResponseBody
	public City findById(long id) {
		City object = new City();
		object = cityRepository.findOne(id);
		return object;
	}

	@RequestMapping("/name")
	@ResponseBody
	public List<City> findByName(String name) {
		List<City> object = new ArrayList<City>();
		object = cityRepository.findByName(name);
		return object;
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, Double serverid, String country, String temperature, String humidity, String pressure,
			String visibility, String wind_speed, Double sunrise, Double sunset, Double longitude, Double latitude,
			Boolean deleted) {
		City object = new City();
		try {
			object = new City(name, serverid, country, temperature, humidity, pressure, visibility, wind_speed, sunrise, sunset, longitude, latitude, deleted);
			cityRepository.save(object);
		}
		catch (Exception ex) {
			return "Error creating the new City: " + ex.toString();
		}
		return "User succesfully created new City! (id = " + object.getId() + ")";
	}

	@RequestMapping("/createObject")
	@ResponseBody
	public String create(City tmpCity) {
		City object = new City();
		try {
			object = tmpCity;
			cityRepository.save(object);
		}
		catch (Exception ex) {
			return "Error creating the new City: " + ex.toString();
		}
		return "User succesfully created new City! (id = " + object.getId() + ")";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			City object = cityRepository.findOne(id);
			cityRepository.delete(object);
		}
		catch (Exception ex) {
			return "Error deleting the City: " + ex.toString();
		}
		return "City succesfully deleted!";
	}

	@RequestMapping("/softDelete")
	@ResponseBody
	public String softDelete(long id) {
		try {
			City object = cityRepository.findOne(id);
			object.setDeleted(true);
			cityRepository.save(object);
		}
		catch (Exception ex) {
			return "Error deleting the City: " + ex.toString();
		}
		return "City succesfully deleted!";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateCity(long id, String name, Double serverid, String country, String temperature, String humidity, String pressure,
			String visibility, String wind_speed, Double sunrise, Double sunset, Double longitude, Double latitude,
			Boolean deleted) {
		try {
			City object = cityRepository.findOne(id);
			object.setName(name);
			object.setServerid(serverid);
			object.setCountry(country);
			object.setTemperature(temperature);
			object.setHumidity(humidity);
			object.setPressure(pressure);
			object.setVisibility(visibility);
			object.setWind_speed(wind_speed);
			object.setSunrise(sunrise);
			object.setSunset(sunset);
			object.setLatitude(latitude);
			object.setLongitude(longitude);
			object.setDeleted(deleted);
			cityRepository.save(object);
		}
		catch (Exception ex) {
			return "Error updating the City: " + ex.toString();
		}
		return "City succesfully updated!";
	}

	@RequestMapping("/updateCity")
	@ResponseBody
	public void updateCity(City city) {
		try {
			City object = new City();
			object = findById(city.getId());
			object.setName(city.getName());
			object.setServerid(city.getServerid());
			object.setCountry(city.getCountry());
			object.setTemperature(city.getTemperature());
			object.setHumidity(city.getHumidity());
			object.setPressure(city.getPressure());
			object.setVisibility(city.getVisibility());
			object.setWind_speed(city.getWind_speed());
			object.setSunrise(city.getSunrise());
			object.setSunset(city.getSunrise());
			object.setLatitude(city.getLatitude());
			object.setLongitude(city.getLongitude());
			object.setDeleted(city.getDeleted());
			cityRepository.save(object);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error updating the City: " + ex.toString());
		}
		System.out.println("City succesfully updated!");
	}

	@RequestMapping("/updateCity_Deleted")
	@ResponseBody
	public String updateCity_Deleted(String name, Boolean deleted) {
		try {
			List<City> object = new ArrayList<City>();
			object = cityRepository.findByName(name);
			for (City ct : object) {
				ct.setDeleted(deleted);
				cityRepository.save(ct);
			}
		}
		catch (Exception ex) {
			return "Error updating the City: " + ex.toString();
		}
		return "City succesfully updated!";
	}

	@RequestMapping("/updateSoftDeleted")
	@ResponseBody
	public String updateCitySoftDeleted(long id, Boolean deleted) {
		try {
			City object = cityRepository.findOne(id);
			object.setDeleted(deleted);
			cityRepository.save(object);
		}
		catch (Exception ex) {
			return "Error updating the City: " + ex.toString();
		}
		return "City succesfully updated!";
	}

	@RequestMapping("/isExistByName")
	@ResponseBody
	public boolean isExistByName(String name) {
		List<City> object = new ArrayList<City>();
		try {
			object = cityRepository.findByName(name);
			if (object == null || object.size() == 0)
				return false;
			else 
				return true;
		}
		catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping("/isSoftDeletedByName")
	@ResponseBody
	public boolean isSoftDeleted(String name) {
		List<City> object = new ArrayList<City>();
		try {
			object = cityRepository.findByName(name);
			if (object == null)
				return false;
			else 
				for (City ct : object) {
					if (ct.getDeleted()) {
						return true;
					}else {
						return false;
					}
				}
		}
		catch (Exception ex) {
			return false;
		}
		return false;
	}

	@RequestMapping("/isExistOrSoftDeletedByName")
	@ResponseBody
	public boolean isExistOrSoftDeletedByName(String name) {
		List<City> object = new ArrayList<City>();
		try {
			object = cityRepository.findByName(name);
			if (object == null)
				return false;
			else 
				for (City ct : object) {
					if (ct.getDeleted()) {
						return true;
					}else {
						return false;
					}
				}
		}
		catch (Exception ex) {
			return false;
		}
		return false;
	}

}
