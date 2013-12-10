package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("personObj") 
public class TeacherController {

	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String teacher(){
		return "teacher";
	}
}
