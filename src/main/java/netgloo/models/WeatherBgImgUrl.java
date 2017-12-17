package netgloo.models;

import org.springframework.stereotype.Component;

@Component
public class WeatherBgImgUrl {
	
	/**
	 * Default / Nis, Belgrade...
	 */
	String cityName;
	/**
	 * day / night
	 */
	String dayNight;
	/**
	 * hot / normal / cold
	 * 	Hot >= 25
		Normal >= 10, < 25
		Cold < 10 
	 */
	String temperatureLevel;
	/**
	 * fine / raining / snowing
	 */
	String precipitation;
	/**
	 * thunderstorm / foggy
	 */
	String disasters;
	public WeatherBgImgUrl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeatherBgImgUrl(String cityName, String dayNight, String temperatureLevel, String precipitation,
			String disasters) {
		super();
		this.cityName = cityName;
		this.dayNight = dayNight;
		this.temperatureLevel = temperatureLevel;
		this.precipitation = precipitation;
		this.disasters = disasters;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDayNight() {
		return dayNight;
	}
	public void setDayNight(String dayNight) {
		this.dayNight = dayNight;
	}
	public String getTemperatureLevel() {
		return temperatureLevel;
	}
	public void setTemperatureLevel(String temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}
	public String getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}
	public String getDisasters() {
		return disasters;
	}
	public void setDisasters(String disasters) {
		this.disasters = disasters;
	}
	@Override
	public String toString() {
		return "WeatherBgImgUrl [cityName=" + cityName + ", dayNight=" + dayNight + ", temperatureLevel="
				+ temperatureLevel + ", precipitation=" + precipitation + ", disasters=" + disasters + "]";
	}
}
