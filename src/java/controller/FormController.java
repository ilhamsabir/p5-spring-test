/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.LinkedHashMap;
import java.util.Map;
import model.UserModel;
import model.UserModelValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nice
 */

@Controller
@RequestMapping(value="form.htm")
public class FormController {

	private UserModelValidator validator;

	public FormController() {
		this.validator = new UserModelValidator();
	}



	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(){

		ModelAndView mav = new ModelAndView();

		// this view from WEB-INF/jsp
		mav.setViewName("form");

		mav.addObject("user",new UserModel());

		return mav;
	}


	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView form(@ModelAttribute("user") UserModel userModel,
			BindingResult result,
			SessionStatus status){

		//send data to validate
		this.validator.validate(userModel, result);

		//check errors
		if(result.hasErrors()){
			ModelAndView mav = new ModelAndView();
			// this view from WEB-INF/jsp
			mav.setViewName("form");

			mav.addObject("user",new UserModel());
			return mav;
		}
		else{
			ModelAndView mav = new ModelAndView();
			// this view from WEB-INF/jsp
			mav.setViewName("success");

			mav.addObject("name",userModel.getName());
			mav.addObject("email",userModel.getEmail());
			mav.addObject("age",userModel.getAge());

			return mav;
		}
	}
}
