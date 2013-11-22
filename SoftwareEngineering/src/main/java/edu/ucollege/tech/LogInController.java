package edu.ucollege.tech;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.ucollege.tech.OM.Person;

/**
 * Handles requests for the application login page.
 */
@Controller
public class LogInController {
	
	@RequestMapping(value = "/login/request", method = RequestMethod.GET)
	public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
		try{
			Person p = new Person();
			p.login(name, password);
		}catch(Exception e){
			System.out.println(e.toString());
			return "redirect:/home";
		}
		return "redirect:/Read";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
}
