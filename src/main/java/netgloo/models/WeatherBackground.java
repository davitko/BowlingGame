package netgloo.models;

import org.springframework.stereotype.Component;

@Component
public class WeatherBackground {
	
	String display;
	String url;
	public WeatherBackground() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeatherBackground(String display, String url) {
		super();
		this.display = display;
		this.url = url;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
