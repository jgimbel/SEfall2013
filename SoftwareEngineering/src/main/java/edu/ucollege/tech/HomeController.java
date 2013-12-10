package edu.ucollege.tech;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;

import edu.ucollege.tech.OM.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, ServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String cookie = request.getAttribute("AccountID").toString();
		if(!cookie.equals("0")){
			String role = request.getAttribute("Role").toString();
		 	if(role=="student"){
				return "redirect:/student";
			}else{
				return "redirect:/teach";
			}
		} else {

			model.addAttribute("serverTime", "0" );
			return "home";
		 	
		}
	}
	
}
