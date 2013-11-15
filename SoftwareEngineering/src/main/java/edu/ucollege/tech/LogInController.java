package edu.ucollege.tech;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ucollege.tech.Connections.MySQL;
import edu.ucollege.tech.OM.Person;

/**
 * Handles requests for the application login page.
 */
@Controller
public class LogInController {
	
	@RequestMapping(value = "/login/request", method = RequestMethod.GET)
	public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
		Person p = new Person();
		p.login(name, password);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
}
