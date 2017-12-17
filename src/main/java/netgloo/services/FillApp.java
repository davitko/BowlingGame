package netgloo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;

import netgloo.models.CarouselPack;

@Controller
public class FillApp {

	public TreeMap<String, String> images = new TreeMap<String,String>();
	public List<CarouselPack> carouselImg = new ArrayList<CarouselPack>();

	public FillApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void fillImgUrls() {
		String tags = "";
		String extension = ".jpg";

		tags = "default";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,cold,fine";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,cold,raining";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,day,normal,fine";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "default,night,hot";
		images.put(tags, tags + extension);

		// Amsterdam
		tags = "";
		tags = "Amsterdam,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Amsterdam,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Amsterdam,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Amsterdam,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Amsterdam,night,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Amsterdam,night,normal";
		images.put(tags, tags + extension);
		//**********************************

		// Belgrade
		tags = "";
		tags = "Belgrade,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Belgrade,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Belgrade,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Belgrade,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Belgrade,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Belgrade,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Berlin
		tags = "";
		tags = "Berlin,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,night,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,night,hot,fine";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Berlin,night,normal";
		images.put(tags, tags + extension);
		// **********************************

		// Istanbul
		tags = "";
		tags = "Istanbul,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Istanbul,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Istanbul,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Istanbul,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Istanbul,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Istanbul,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// London
		tags = "";
		tags = "London,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "London,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "London,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "London,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "London,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "London,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Miami
		tags = "";
		tags = "Miami,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Miami,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Miami,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Miami,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Miami,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Miami,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Moscow
		tags = "";
		tags = "Moscow,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Moscow,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Moscow,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Moscow,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Moscow,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Moscow,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Munich
		tags = "";
		tags = "Munich,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Munich,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Munich,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Munich,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Munich,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Munich,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// New York City
		tags = "";
		tags = "New York,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "New York,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "New York,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "New York,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "New York,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "New York,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Paris
		tags = "";
		tags = "Paris,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Paris,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Paris,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Paris,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Paris,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Paris,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Rome
		tags = "";
		tags = "Rome,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Rome,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Rome,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Rome,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Rome,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Rome,night,hot";
		images.put(tags, tags + extension);
		// **********************************

		// Vienna
		tags = "";
		tags = "Vienna,day,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Vienna,day,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Vienna,day,hot";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Vienna,night,cold";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Vienna,night,normal";
		images.put(tags, tags + extension);
		tags = "";
		tags = "Vienna,night,hot";
		images.put(tags, tags + extension);
		// **********************************








		//	     printTree(images);


	}

	//	public void fillCarouselImg() {
	//		for (int i = 1; i < 6; i++) {
	//			CarouselPack carouselPack = new CarouselPack();
	//			carouselPack.setSummer("s" + i + ".jpg");
	//			carouselPack.setAutumn("a" + i + ".jpg");
	//			carouselPack.setWinter("w" + i + ".jpg");
	//			carouselPack.setSpring("s" + i + ".jpg");
	//			carouselImg.add(carouselPack);
	//		}
	//		carouselImg.forEach(item -> System.out.println(item));
	//	}

	public void fillCarouselImg() {
		for (int i = 1; i < 7; i++) {
			CarouselPack carouselPack = new CarouselPack();
			carouselPack.setIndex(i);
			carouselPack.setSummer("summer.jpg");
			carouselPack.setAutumn("autumn.jpg");
			carouselPack.setWinter("winter.jpg");
			carouselPack.setSpring("spring.jpg");
			carouselImg.add(carouselPack);
		}
		//		carouselImg.forEach(item -> System.out.println(item));
	}

	public void printTree(Map<?, ?> map){
		for (Object key: map.keySet()){
			String value= (String) map.get(key);
			System.out.println("At key= "+ key+ " the value is "+ value);
		}
	}

}
