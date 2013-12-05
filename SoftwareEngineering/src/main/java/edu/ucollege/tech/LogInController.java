package edu.ucollege.tech;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.ucollege.tech.OM.Person;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("personObj") 
public class LogInController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
		Person p = new Person();
		try{
			p.login(name, password);
		}catch(Exception e){
			System.out.println(e.toString());
			return "redirect:/";
		}
		if(p.isStudent()){
			return "redirect:/student";
		}else { //they are teacher
			return "redirect:/teacher";
		}
	}
	
}
