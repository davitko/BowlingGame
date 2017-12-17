package netgloo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Miloš Davitković
 *
 */
@Entity
@Table(name = "city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4345629985870301199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	Double serverid;
	String country;
	String temperature;
	String humidity;
	String pressure;
	String visibility;
	String wind_speed;
	Double sunrise;
	Double sunset;
	Double longitude;
	Double latitude;
	Double dateTime;
	Boolean deleted;
	
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String name, Double serverid, String country, String temperature, String humidity, String pressure,
			String visibility, String wind_speed, Double sunrise, Double sunset, Double longitude, Double latitude,
			Boolean deleted) {
		super();
		this.name = name;
		this.serverid = serverid;
		this.country = country;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.visibility = visibility;
		this.wind_speed = wind_speed;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deleted = deleted;
	}
	public City(long id) {
		super();
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getServerid() {
		return serverid;
	}
	public void setServerid(Double serverid) {
		this.serverid = serverid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(String wind_speed) {
		this.wind_speed = wind_speed;
	}
	public Double getSunrise() {
		return sunrise;
	}
	public void setSunrise(Double sunrise) {
		this.sunrise = sunrise;
	}
	public Double getSunset() {
		return sunset;
	}
	public void setSunset(Double sunset) {
		this.sunset = sunset;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getDateTime() {
		return dateTime;
	}
	public void setDateTime(Double dateTime) {
		this.dateTime = dateTime;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", serverid=" + serverid + ", country=" + country
				+ ", temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + ", visibility="
				+ visibility + ", wind_speed=" + wind_speed + ", sunrise=" + sunrise + ", sunset=" + sunset
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", dateTime=" + dateTime + ", deleted="
				+ deleted + "]";
	}
	
	
	
	
}
