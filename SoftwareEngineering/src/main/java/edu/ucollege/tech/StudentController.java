package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("personObj") 
public class StudentController {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(Model model){
		
		return "student";
	}

}
