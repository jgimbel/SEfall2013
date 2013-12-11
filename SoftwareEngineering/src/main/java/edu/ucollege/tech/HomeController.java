package edu.ucollege.tech;

import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, ServletRequest request) {
		String cookie = request.getAttribute("AccountID").toString();
		if(cookie.matches("\\d+") && !cookie.equals("0")){
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
