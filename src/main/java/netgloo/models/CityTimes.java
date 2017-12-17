package netgloo.models;

import org.springframework.stereotype.Component;

@Component
public class CityTimes {
	
	String sunrise;
	String sunset;
	String dateTime;
	public CityTimes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityTimes(String sunrise, String sunset, String dateTime) {
		super();
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.dateTime = dateTime;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "CityTimes [sunrise=" + sunrise + ", sunset=" + sunset + ", dateTime=" + dateTime + "]";
	}
}

