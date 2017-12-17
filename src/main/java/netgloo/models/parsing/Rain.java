package netgloo.models.parsing;

import org.springframework.stereotype.Component;

@Component
public class Rain {

	Integer threeH;

	public Rain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rain(Integer threeH) {
		super();
		this.threeH = threeH;
	}

	public Integer getThreeH() {
		return threeH;
	}

	public void setThreeH(Integer threeH) {
		this.threeH = threeH;
	}

	@Override
	public String toString() {
		return "Rain [threeH=" + threeH + "]";
	}
	
	
	
	
	
}
