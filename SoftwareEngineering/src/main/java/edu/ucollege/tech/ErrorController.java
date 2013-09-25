package edu.ucollege.tech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ErrorController {

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String Error(){
		
	return "error";
	}
}
