package netgloo.models.parsing;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class Clouds {

	Integer all;

	public Clouds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clouds(Integer all) {
		super();
		this.all = all;
	}

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return "Clouds [all=" + all + "]";
	}
	
}
