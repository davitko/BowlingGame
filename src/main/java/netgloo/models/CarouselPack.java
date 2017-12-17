package netgloo.models;

import org.springframework.stereotype.Component;

@Component
public class CarouselPack {
	
	Integer index;
	String summer;
	String autumn;
	String winter;
	String spring;
	public CarouselPack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarouselPack(String summer, String autumn, String winter, String spring) {
		super();
		this.summer = summer;
		this.autumn = autumn;
		this.winter = winter;
		this.spring = spring;
	}
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getSummer() {
		return summer;
	}
	public void setSummer(String summer) {
		this.summer = summer;
	}
	public String getAutumn() {
		return autumn;
	}
	public void setAutumn(String autumn) {
		this.autumn = autumn;
	}
	public String getWinter() {
		return winter;
	}
	public void setWinter(String winter) {
		this.winter = winter;
	}
	public String getSpring() {
		return spring;
	}
	public void setSpring(String spring) {
		this.spring = spring;
	}
	@Override
	public String toString() {
		return "CarouselPack [index=" + index + ", summer=" + summer + ", autumn=" + autumn + ", winter=" + winter
				+ ", spring=" + spring + "]";
	}
	
	
}
