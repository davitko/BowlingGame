package netgloo.models.parsing;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class Coord {

	Double lon;
	Double lat;
	public Coord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coord(Double lon, Double lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Coord [lon=" + lon + ", lat=" + lat + "]";
	}
	
	
}
