/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author nice
 */
public class UserModelValidator implements Validator{


	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;


	@Override
	public boolean supports(Class<?> type) {
		return UserModel.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object o, Errors errors) {

		UserModel userModel = (UserModel)o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name","Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.name","Email Required");

		if(!(userModel.getEmail() != null && userModel.getEmail().isEmpty())){

			//validate email with regular expressions
			this.pattern = Pattern.compile(PATTERN_EMAIL);
			this.matcher = pattern.matcher(userModel.getEmail());
				if(!matcher.matches()){
					errors.rejectValue("email", "email.incorrect", "EL email " + userModel.getEmail() + " Email Invalid");
				}
		}


		if(userModel.getAge()==0) errors.rejectValue("age", "age.incorrect","Age invalid");

	}
}
