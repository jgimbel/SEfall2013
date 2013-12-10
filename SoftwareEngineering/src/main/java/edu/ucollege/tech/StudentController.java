package edu.ucollege.tech;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("personObj") 
public class StudentController {
	
	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String student(){
		return "library";
	}
	
	@RequestMapping(value="/addStudentSubmit", method=RequestMethod.POST)
	public String addStudent(@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="class") String Class, @RequestParam(value="password") String password, HttpServletResponse response){
		
		
		
		
		return "redirect:/teach";
		
	}

}
