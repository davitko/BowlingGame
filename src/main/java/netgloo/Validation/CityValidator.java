package netgloo.Validation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import netgloo.controllers.IndexController;
import netgloo.models.City;

public class CityValidator implements Validator {
	
	@Autowired
	IndexController indexController;

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return City.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		City city = (City) target;
		
		if (city.getName() == null) {
			errors.rejectValue("name", "Name cannot be emmpty!");
		}
		else if(city.getName().length() < 1 || city.getName().length() > 20){
            errors.rejectValue("name", "name[invalidLength]");
        }
		
//		try {
//			if (indexController.isCityExist(city.getName())) {
//				errors.rejectValue("name", "selected city is already entered, please choose new one!");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		

	}

}
