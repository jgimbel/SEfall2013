package edu.ucollege.tech;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application login page.
 */
@Controller
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogInController.class);
	
	@RequestMapping(value = "/login/{ID}", method = RequestMethod.GET)
	public String login(Model model, @PathVariable long ID) {
		logger.info("Welcome to login! " + ID);
		
		
		return "redirect:/start";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		
		return "login";
	
	}
	
}
