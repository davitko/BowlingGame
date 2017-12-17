package netgloo.Validation;

import java.util.List;

public class ValidationCity {
	
	public List<String> recommendedCities;
	public String validationMessage;
	public ValidationCity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidationCity(List<String> recommendedCities, String validationMessage) {
		super();
		this.recommendedCities = recommendedCities;
		this.validationMessage = validationMessage;
	}
	public List<String> getRecommendedCities() {
		return recommendedCities;
	}
	public void setRecommendedCities(List<String> recommendedCities) {
		this.recommendedCities = recommendedCities;
	}
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	@Override
	public String toString() {
		return "ValidationCity [recommendedCities=" + recommendedCities + ", validationMessage=" + validationMessage
				+ "]";
	}
	
}
