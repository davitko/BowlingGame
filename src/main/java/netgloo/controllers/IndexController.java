package netgloo.controllers;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import netgloo.Validation.CityValidator;
import netgloo.Validation.ValidationCity;
import netgloo.com.java.File.FileFn;
import netgloo.com.java.Integer.IntegerFn;
import netgloo.com.java.String.StringFn;
import netgloo.com.java.Time.TimeFn;
import netgloo.models.CarouselPack;
import netgloo.models.City;
import netgloo.models.CityTimes;
import netgloo.models.WeatherBackground;
import netgloo.models.WeatherBgImgUrl;
import netgloo.models.parsing.OpenWeatherMapObject;
import netgloo.repository.CityRepository;
import netgloo.services.CityServices;
import netgloo.services.FillApp;



@Controller
@RequestMapping(value = {"/"}, method = RequestMethod.GET)
public class IndexController {

	@Value("${APPID}") public String APPID;
	@Value("${openWeatherURL}") public String openWeatherURL;
	@Value("${units}") public String units;
	@Value("${language}") public String language;

	public City lastCity;
	public City detailCity;
	public CityTimes detailCityTime;
	public CityTimes cityTimes;
	public List<City> cityRecommendationByName;
	public ValidationCity validationCity;

	@Autowired
	CityServices cityServices;
	@Autowired
	FillApp fillApp;
	@Autowired
	TimeFn timeFn;
	@Autowired
	StringFn stringFn;

	public IndexController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)	
	public String index(Model model) {
		IntegerFn integerFn = new IntegerFn(); 
		Integer carouselIndex = 0;
		CarouselPack carouselPack = fillApp.carouselImg.get(carouselIndex);
		model.addAttribute("carouselPack", carouselPack);
		return "index";
	}



	/**
	 * 
	 * @param model
	 * @return This string will be suffixed and prefixed with suffix and prefix defined in 
	 * view resolver(see spring-servlet.xml above) to form the real view file name.
	 */
	//	@RequestMapping(method = RequestMethod.GET, produces = "text/html;charset=UTF-8")	
	@RequestMapping(value = {"/addCity"}, method = RequestMethod.GET)	
	public String addCity(Model model) {
		String showPopUp="";
		//		model.addAttribute("cities", cityServices.findAll());
		model.addAttribute("cities", cityServices.findAllSoft());
		System.out.println("@index: Found " + cityServices.count());
		//		if (validationCity != null) {
		model.addAttribute("validationCity", validationCity);
		//		}


		//		City lastCity = cityServices.getLast();
		//		WeatherBackground weatherBg = new WeatherBackground();
		//		if (lastCity != null)
		//			weatherBg.setDisplay("show");
		////			weatherBg.setDisplay("hide");
		//		else 
		//			weatherBg.setDisplay("hide");
		//		String imgName = createImageName(lastCity);
		//		
		//		if (imgName != null)
		//			weatherBg.setUrl(imgName);
		//		model.addAttribute("weatherBg", weatherBg);

		IntegerFn integerFn = new IntegerFn(); 
		Integer carouselIndex = integerFn.getRandomNumberInRange(0, 5);
		CarouselPack carouselPack = fillApp.carouselImg.get(carouselIndex);
		model.addAttribute("carouselPack", carouselPack);

		return "addCity";
	}

	@RequestMapping(value = {"/index"}, method = RequestMethod.GET)	
	public String index2(Model model) {
		model.addAttribute("cities", cityServices.findAll());
		System.out.println("@index: Found " + cityServices.count());

		City lastCity = cityServices.getLast();
		WeatherBackground weatherBg = new WeatherBackground();
		if (lastCity != null)
			//			weatherBg.setDisplay("show");
			weatherBg.setDisplay("hide");
		else 
			weatherBg.setDisplay("hide");
		String imgName = createImageName(lastCity);

		if (imgName != null)
			weatherBg.setUrl(imgName);
		model.addAttribute("weatherBg", weatherBg);

		IntegerFn integerFn = new IntegerFn(); 
		Integer carouselIndex = integerFn.getRandomNumberInRange(0, 4);
		CarouselPack carouselPack = fillApp.carouselImg.get(carouselIndex);
		model.addAttribute("carouselPack", carouselPack);

		return "index";
	}

	@RequestMapping(value = {"/details"}, method = RequestMethod.GET)	
	public String details(Model model) {

		System.out.println("Detail Time: " + detailCity);
		model.addAttribute("detailCity", detailCity);

		cityTimes = new CityTimes();
		if (detailCity != null)
			cityTimes.setDateTime(timeFn.fromUnixToSpecificString(detailCity.getDateTime(), "hh a"));
		else
			cityTimes.setDateTime("");
		cityTimes.setSunrise(timeFn.fromUnixToSpecificString(detailCity.getSunrise(), "HH:mm"));
		cityTimes.setSunset(timeFn.fromUnixToSpecificString(detailCity.getSunset(), "HH:mm"));

		System.out.println("City Time: " + cityTimes);
		model.addAttribute("cityTimes", cityTimes);

		WeatherBackground weatherBg = new WeatherBackground();
		if (detailCity != null)
			weatherBg.setDisplay("show");
		else 
			weatherBg.setDisplay("hide");
		String imgName = createImageName(detailCity);

		if (imgName != null)
			weatherBg.setUrl(imgName);
		else
			weatherBg.setUrl("default.jpg");
		model.addAttribute("weatherBg", weatherBg);
		return "details";
	}

	@RequestMapping(value = {"/details/{id}"}, method = RequestMethod.GET)	
	public String detailsSelect(@PathVariable("id") long id, Model model) {
		detailCity = cityServices.findById(id);
		model.addAttribute("detailCity", detailCity);

		//		CityTimes cityTimes = new CityTimes();
		//		cityTimes.setDateTime(timeFn.fromUnixToSpecificString(detailCity.getDateTime().longValue(), "hh a"));
		//		cityTimes.setSunrise(timeFn.fromUnixToSpecificString(detailCity.getSunrise().longValue(), "hh:mm"));
		//		cityTimes.setSunset(timeFn.fromUnixToSpecificString(detailCity.getSunset().longValue(), "hh:mm"));
		//		model.addAttribute("cityTimes", cityTimes);
		//		
		//		WeatherBackground weatherBg = new WeatherBackground();
		//		if (lastCity != null)
		//			weatherBg.setDisplay("show");
		//		else 
		//			weatherBg.setDisplay("hide");
		//		String imgName = createImageName(detailCity);
		//		
		//		if (imgName != null)
		//			weatherBg.setUrl(imgName);
		//		else
		//			weatherBg.setUrl("default.jpg");
		//		model.addAttribute("weatherBg", weatherBg);
		return "redirect:/details";
	}

	@RequestMapping(value = {"/refresh/{id}"}, method = RequestMethod.GET)	
	public String refresh(@PathVariable("id") long id, Model model) {
		detailCity = cityServices.findById(id);
		detailCity = updateCityInformation(detailCity);
		cityServices.updateCity(detailCity);
		//		model.addAttribute("detailCity", detailCity);
		return "redirect:/details";
	}

	@RequestMapping("/remove/{id}")
	public String removeCity(@PathVariable("id") long id){
		cityServices.delete(id);
		return "redirect:/addCity";
	}

	@RequestMapping("/softRemove/{id}")
	public String softRemoveCity(@PathVariable("id") long id){
		cityServices.softDelete(id);
		return "redirect:/addCity";
	}

	@RequestMapping("/refreshCity/{id}")
	public String refreshCity(@PathVariable("id") long id){

		return "redirect:/details";
	}



	//	@RequestMapping(value = {"/wellcome"}, method = RequestMethod.GET)
	//	public String wellcome(Model model) {
	//		//        model.addAttribute("userForm", new User());
	//
	//		return "wellcome";
	//	}
	//
	//	@RequestMapping("/myjsp")
	//	public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	//		model.addAttribute("name", name);
	//		return "myJsp";
	//	}

	//	@RequestMapping(value ="/addCity/add", method = RequestMethod.GET)
	//	@ResponseStatus(value=HttpStatus.OK)
	//	public String addCityGet(Model model) throws IOException {
	//		return "addCity";
	//	}

	@RequestMapping(value ="/addCity/add", method = RequestMethod.POST)
	//	@ResponseStatus(value=HttpStatus.OK)
	public String addCity(@ModelAttribute("city") City city, BindingResult result, Model model) throws IOException {
		//		String cityName = "Belgrade";

		CityValidator cityValidator = new CityValidator();
		cityValidator.validate(city, result);

		if (result.hasErrors()){
			// do something
			return "index";
		}
		else {
			// do something else
		}

		String cityName = city.getName();
		cityName = stringFn.capitalizeFirstLetter(cityName);
		System.out.println("@addCity:: City name: " + cityName);
		if (cityName != null) {
			try {
				//				cityRecommendationByName = null;
				validationCity = new ValidationCity();
				if (isCityExist(cityName)) {
					if (!cityServices.isExistByName(cityName)) {
						City newCity = getCityInformation(cityName);
						//			model.addAttribute("newCity", newCity);
					}else { // !cityServices.isExistByName(cityName)
						if (cityServices.isSoftDeleted(cityName)) {
							validationCity.validationMessage = "City '" + cityName + "' is soft deleted from History!";
							System.out.println("City: " + cityName + " is soft deleted from History!");
						}else {
							validationCity.validationMessage = "City '" + cityName + "' already exist in History!";
							System.out.println("City: '" + cityName + "' already exist in History!");							
						}
					}
				}else { // isCityExist(cityName)
					validationCity.validationMessage = "City " + cityName + " doesn't exist on Weather Map!";
					System.out.println("City " + cityName + " doesn't exist on Weather Map!");
					//					cityRecommendationByName = new ArrayList<City>();
					List<String> recommendedCity = recommendCityName(cityName);
					validationCity.setRecommendedCities(recommendedCity);
					//					for (String str : recommendedCity) {
					//						validationCity.setRecommendedCities(recommendedCity);
					//					}
					//					return "redirect:/addCity";
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("@addCity: Error!");
				e.printStackTrace();
				//				return "redirect:/addCity";
			}

		}else {
			System.out.println("Internal problem City is null!");
			//			return "redirect:/addCity";
		}

		//		model.addAttribute("cities", cityServices.findAllSoft());
		return "redirect:/addCity";
		//		return "redirect:index";
	}

	@RequestMapping("/addRecommendedCity/{cityName}")
	public String addRecommendedCity(@PathVariable("cityName") String cityName){

		cityName = stringFn.capitalizeFirstLetter(cityName);
		System.out.println("@addCity:: City name: " + cityName);
		if (cityName != null) {
			try {
				//				cityRecommendationByName = null;
				validationCity = new ValidationCity();
				if (isCityExist(cityName)) {
					if (!cityServices.isExistByName(cityName)) {
						City newCity = getCityInformation(cityName);
						//			model.addAttribute("newCity", newCity);
					}else { // !cityServices.isExistByName(cityName)
						if (cityServices.isSoftDeleted(cityName)) {
							validationCity.validationMessage = "City '" + cityName + "' is soft deleted from History!";
							System.out.println("City: " + cityName + " is soft deleted from History!");
						}else {
							validationCity.validationMessage = "City '" + cityName + "' already exist in History!";
							System.out.println("City: '" + cityName + "' already exist in History!");							
						}
					}
				}else { // isCityExist(cityName)
					validationCity.validationMessage = "City " + cityName + " doesn't exist on Weather Map!";
					System.out.println("City " + cityName + " doesn't exist on Weather Map!");
					//					cityRecommendationByName = new ArrayList<City>();
					List<String> recommendedCity = recommendCityName(cityName);
					validationCity.setRecommendedCities(recommendedCity);
					//					for (String str : recommendedCity) {
					//						validationCity.setRecommendedCities(recommendedCity);
					//					}
					//					return "redirect:/addCity";
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("@addCity: Error!");
				e.printStackTrace();
				//				return "redirect:/addCity";
			}

		}else {
			System.out.println("Internal problem City is null!");
			//			return "redirect:/addCity";
		}


		return "redirect:/addCity";
	}



	public City getCityInformation(String cityName)
	{
		String uri = openWeatherURL + "q=" + cityName + "&units=" + units + "&language=" + language + "&appid=" + APPID;
		RestTemplate restTemplate = new RestTemplate();
		//	    String result = restTemplate.getForObject(uri, String.class);
		OpenWeatherMapObject result = restTemplate.getForObject(uri, OpenWeatherMapObject.class);
		City tmpCity = new City();
		try {
			if (result.getSys().getCountry() != null)
				tmpCity.setCountry(result.getSys().getCountry());
			else
				tmpCity.setCountry("");
			tmpCity.setDeleted(false);
			if (result.getMain().getHumidity() != null)
				tmpCity.setHumidity(result.getMain().getHumidity().toString());
			else
				tmpCity.setHumidity("");
			if (result.getName() != null)
				tmpCity.setName(result.getName());
			else
				tmpCity.setName("");
			if (result.getCoord().getLat() != null)
				tmpCity.setLatitude(result.getCoord().getLat());
			else
				tmpCity.setLatitude(0.0);
			if (result.getCoord().getLon() != null)
				tmpCity.setLongitude(result.getCoord().getLon());
			else
				tmpCity.setLongitude(0.0);
			if (result.getMain().getPressure() != null)
				tmpCity.setPressure(result.getMain().getPressure().toString());
			else
				tmpCity.setPressure("");
			if (result.getId() != null)
				tmpCity.setServerid(result.getId());
			else
				tmpCity.setServerid(0.0);
			if(result.getSys().getSunrise() != null)
				tmpCity.setSunrise(result.getSys().getSunrise());
			else 
				tmpCity.setSunrise(0.0);
			if (result.getSys().getSunset() != null)
				tmpCity.setSunset(result.getSys().getSunset());
			else
				tmpCity.setSunset(0.0);
			if (result.getMain().getTemp() != null)
				tmpCity.setTemperature(result.getMain().getTemp().toString());
			else
				tmpCity.setTemperature("");
			if (result.getVisibility() != null)
				tmpCity.setVisibility(result.getVisibility().toString());
			else
				tmpCity.setVisibility("");
			if (result.getWind().getSpeed() != null)
				tmpCity.setWind_speed(result.getWind().getSpeed().toString());
			else
				tmpCity.setWind_speed("");
			if (result.getDt() != null)
				tmpCity.setDateTime(result.getDt());
			else
				tmpCity.setDateTime(0.0);
			cityServices.create(tmpCity);
			//	    System.out.println(result);
			System.out.println(result.toString());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("@getCityInformation: Error occured!");
			e.printStackTrace();
		}
		return tmpCity;
	}

	public City updateCityInformation(City tmpCity)
	{
		String uri = openWeatherURL + "q=" + tmpCity.getName() + "&units=" + units + "&language=" + language + "&appid=" + APPID;
		RestTemplate restTemplate = new RestTemplate();
		//	    String result = restTemplate.getForObject(uri, String.class);
		OpenWeatherMapObject result = restTemplate.getForObject(uri, OpenWeatherMapObject.class);
		//		City tmpCity = new City();
		try {
			tmpCity.setCountry(result.getSys().getCountry());
			tmpCity.setDeleted(false);
			tmpCity.setHumidity(result.getMain().getHumidity().toString());
			tmpCity.setName(result.getName());
			tmpCity.setLatitude(result.getCoord().getLat());
			tmpCity.setLongitude(result.getCoord().getLon());
			tmpCity.setPressure(result.getMain().getPressure().toString());
			tmpCity.setServerid(result.getId());
			tmpCity.setSunrise(result.getSys().getSunrise());
			tmpCity.setSunset(result.getSys().getSunset());
			tmpCity.setTemperature(result.getMain().getTemp().toString());
			tmpCity.setVisibility(result.getVisibility().toString());
			tmpCity.setWind_speed(result.getWind().getSpeed().toString());
			tmpCity.setDateTime(result.getDt());
			//			detailCityTime.setDateTime(timeFn.fromUnixToDate(result.getDt().longValue()).toString());
			//			detailCityTime.setSunrise(timeFn.fromUnixToDate(result.getSys().getSunrise().longValue()).toString());
			//			detailCityTime.setSunset(timeFn.fromUnixToDate(result.getSys().getSunset().longValue()).toString());
			//			cityServices.create(tmpCity);
			//	    System.out.println(result);
			System.out.println(result.toString());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("@getCityInformation: Error occured!");
		}
		return tmpCity;
	}

	public String createImageName(City city) {
		String result = "";
		WeatherBgImgUrl tmpName = createImageNameObject(city);

		// amsterdam, day, cold, fine, foggy
		result = "";
		result += tmpName.getCityName();
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		if (tmpName.getPrecipitation() != null) {
			result += ",";
			result += tmpName.getPrecipitation();
		}
		if (tmpName.getDisasters() != null) {
			result += ",";
			result += tmpName.getDisasters();
		}
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// amsterdam, day, hot
		result = "";
		result += tmpName.getCityName();
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// ##############################################################

		// Default Name

		// default, day, cold, fine, foggy
		result = "";
		result += "default";
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		if (tmpName.getPrecipitation() != null) {
			result += ",";
			result += tmpName.getPrecipitation();
		}
		if (tmpName.getDisasters() != null) {
			result += ",";
			result += tmpName.getDisasters();
		}
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// default, day, normal, raining
		result = "";
		result += "default";
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		if (tmpName.getPrecipitation() != null) {
			result += " ";
			result += tmpName.getPrecipitation();
		}
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// default, day, cold, fine
		result = "";
		result += "default";
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		result += ",";
		result += "fine";
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// default, night, cold
		result = "";
		result += "default";
		result += ",";
		result += tmpName.getDayNight();
		result += ",";
		result += tmpName.getTemperatureLevel();
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// default, night, cold
		result = "";
		result += "default";
		result += ",";
		result += tmpName.getDayNight();
		if (fillApp.images.containsKey(result)) {
			return fillApp.images.get(result);
		}

		// ##############################################################

		//		// default, day, normal, fine
		//		result = "";
		//		result += "default";
		//		result += ",";
		//		result += tmpName.getDayNight();
		//		result += ",";
		//		result += "normal";
		//		result += ",";
		//		result += "fine";
		//		if (fillApp.images.containsKey(result)) {
		//			return fillApp.images.get(result);
		//		}
		//
		//		// default, day, normal
		//		result = "";
		//		result += "default";
		//		result += ",";
		//		result += "day";
		//		result += ",";
		//		result += "normal";
		//		if (fillApp.images.containsKey(result)) {
		//			return fillApp.images.get(result);
		//		}

		result = "";
		result += "default.jpg";
		return result;
	}

	public WeatherBgImgUrl createImageNameObject(City city) {
		WeatherBgImgUrl weatherImg = new WeatherBgImgUrl();
		weatherImg.setCityName(city.getName());

		TimeFn timeFn = new TimeFn();
		Instant now = Instant.now();
		Instant sunrise = timeFn.fromUnixToInstant(city.getSunrise().longValue());
		Instant sunset = timeFn.fromUnixToInstant(city.getSunset().longValue());
		if (now.isAfter(sunrise) && now.isBefore(sunset))
		{ 
			weatherImg.setDayNight("day");
		}
		else {
			weatherImg.setDayNight("night");
		}

		Double temperature = Double.valueOf(city.getTemperature()) / 100;
		if (temperature >= 25)
			weatherImg.setTemperatureLevel("hot");
		if (temperature < 10)
			weatherImg.setTemperatureLevel("cold");
		if (temperature >= 10 && temperature < 25)
			weatherImg.setTemperatureLevel("normal");

		return weatherImg;
	}


	@RequestMapping("/testTree")
	public void createTree() {
		TreeMap<Integer, String> tree = new TreeMap<Integer,String>();
		tree.put(1, "Default");
		tree.put(1, "Cities");
		tree.put(2, "Chuang");
		tree.put(3, "Frank");
		tree.put(4, "David");
		printTree(tree);
		tree.put(51, "Steve");
		tree.put(62, "Benny");
		tree.put(11, "Kevin");
		tree.put(23, "Paul");
		printTree(tree);

		System.out.println("Tree ceilingEntry "+ tree.ceilingEntry(2)); 
		System.out.println("Tree values "+ tree.values());
		System.out.println("Tree values "+ tree.size());
	}

	@RequestMapping("/testTree2")
	public void createTree2() {
		//		 TreeMap<List<String>, String> tree = new TreeMap<List<String>,String>();
		TreeMap<String, String> tree = new TreeMap<String,String>();
		//		 List<String> tags = new ArrayList<String>();
		String tags;
		tags = "Default";
		tree.put(tags, "url1");
		tags += " Day";
		tree.put(tags, "url3");  
		tags += " Sunny"; 
		tree.put(tags, "url2");
		printTree(tree);

		System.out.println("Tree values "+ tree.values());
		System.out.println("Tree values "+ tree.size());

		System.out.println("Tree Default "+ tree.get("Default"));
		System.out.println("Tree Sunny "+ tree.get("Default Day Sunny"));
	}

	@RequestMapping("/citiesFromFile")
	public List<String> citiesFromFile() throws IOException {
		FileFn fileFn = new FileFn();
		List<String> result = fileFn.CSVReaderByColumn("openweather_city_list.txt", "\t", 1);
		//		List<String> result = fileFn.CSVReaderByRow("openweather_city_list.txt", "\t", 1);
		//		result.forEach(item -> System.out.println(item));
		return result;
	}

	@RequestMapping("/citiesExist")
	public Boolean isCityExist(String cityName) throws IOException {
		FileFn fileFn = new FileFn();
		//		Boolean result = fileFn.CSVReaderIsStringExist("openweather_city_list.txt", "\t", "Belgrade");
		Boolean result = fileFn.CSVReaderIsStringExist("openweather_city_list.txt", "\t", cityName);
		System.out.println("@isCityExist Availability City: " + cityName + " on Open Weather Map: " + result );
		return result;
	}

	public void printTree(Map<?, ?> map){
		for (Object key: map.keySet()){
			String value= (String) map.get(key);
			System.out.println("At key= "+ key+ ", the value is "+ value);
		}
	}

	@RequestMapping("/stringTestingNish")
	public void stringTestingNish() {
		String string1 = "Niš";
		String string2 = "Nis";

		System.out.println("similarityOfStringsDamerauLevenshtein: " + stringFn.similarityOfStringsDamerauLevenshtein(string1, string2));
		System.out.println("similarityOfStringsJaroWinkler: " + stringFn.similarityOfStringsJaroWinkler(string1, string2));
		System.out.println("similarityOfStringsLevenshtein: " + stringFn.similarityOfStringsLevenshtein(string1, string2));
		System.out.println("similarityOfStringsMetricLongestCommonSubsequence: " + stringFn.similarityOfStringsMetricLongestCommonSubsequence(string1, string2));
		System.out.println("similarityOfStringsNGram: " + stringFn.similarityOfStringsNGram(string1, string2));
		System.out.println("similarityOfStringsNormalizedLevenshtein: " + stringFn.similarityOfStringsNormalizedLevenshtein(string1, string2));
		System.out.println("similarityOfStringsOptimalStringAlignment: " + stringFn.similarityOfStringsOptimalStringAlignment(string1, string2));
		System.out.println("similarityOfStringsQGram: " + stringFn.similarityOfStringsQGram(string1, string2));
		System.out.println("simpleStringSimilarity: " + stringFn.simpleStringSimilarity(string1, string2));
	}

	@RequestMapping("/stringTestingMunich")
	public void stringTestingMunich() {
		String string1 = "Munich";
		String string2 = "München";

		System.out.println("similarityOfStringsDamerauLevenshtein: " + stringFn.similarityOfStringsDamerauLevenshtein(string1, string2));
		System.out.println("similarityOfStringsJaroWinkler: " + stringFn.similarityOfStringsJaroWinkler(string1, string2));
		System.out.println("similarityOfStringsLevenshtein: " + stringFn.similarityOfStringsLevenshtein(string1, string2));
		System.out.println("similarityOfStringsMetricLongestCommonSubsequence: " + stringFn.similarityOfStringsMetricLongestCommonSubsequence(string1, string2));
		System.out.println("similarityOfStringsNGram: " + stringFn.similarityOfStringsNGram(string1, string2));
		System.out.println("similarityOfStringsNormalizedLevenshtein: " + stringFn.similarityOfStringsNormalizedLevenshtein(string1, string2));
		System.out.println("similarityOfStringsOptimalStringAlignment: " + stringFn.similarityOfStringsOptimalStringAlignment(string1, string2));
		System.out.println("similarityOfStringsQGram: " + stringFn.similarityOfStringsQGram(string1, string2));
		System.out.println("simpleStringSimilarity: " + stringFn.simpleStringSimilarity(string1, string2));
	}

	@RequestMapping("/stringTesting")
	public void stringTesting() {
		String string1 = "Beograd";
		String string2 = "Birmingem";

		System.out.println("similarityOfStringsDamerauLevenshtein: " + stringFn.similarityOfStringsDamerauLevenshtein(string1, string2));
		System.out.println("similarityOfStringsJaroWinkler: " + stringFn.similarityOfStringsJaroWinkler(string1, string2));
		System.out.println("similarityOfStringsLevenshtein: " + stringFn.similarityOfStringsLevenshtein(string1, string2));
		System.out.println("similarityOfStringsMetricLongestCommonSubsequence: " + stringFn.similarityOfStringsMetricLongestCommonSubsequence(string1, string2));
		System.out.println("similarityOfStringsNGram: " + stringFn.similarityOfStringsNGram(string1, string2));
		System.out.println("similarityOfStringsNormalizedLevenshtein: " + stringFn.similarityOfStringsNormalizedLevenshtein(string1, string2));
		System.out.println("similarityOfStringsOptimalStringAlignment: " + stringFn.similarityOfStringsOptimalStringAlignment(string1, string2));
		System.out.println("similarityOfStringsQGram: " + stringFn.similarityOfStringsQGram(string1, string2));
		System.out.println("simpleStringSimilarity: " + stringFn.simpleStringSimilarity(string1, string2));
	}

	public List<String> recommendCityName(String inputCityName) throws IOException {
		List<String> resultList = new ArrayList<String>();
		List<String> inputList = new ArrayList<String>();
		inputList = citiesFromFile();
		resultList = stringFn.recommendSimilarFromList(inputList, inputCityName);
		resultList.forEach(item -> System.out.println(item));
		return resultList;
	}

}
