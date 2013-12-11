package edu.ucollege.tech;

import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("personObj") 
public class StudentController {
	
	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String student(ServletRequest request){
		if(isLoggedIn(request)){
			return "library";
		} else {
			return "redirect:/";
		}
	}
	
	
	private boolean isLoggedIn(ServletRequest request){
		String cookie = request.getAttribute("AccountID").toString();
		if(cookie.matches("\\d+") && !cookie.equals("0")){
		String role = request.getAttribute("Role").toString();
		 	if(role=="student"){
				return true;
			}else{
				return true;
			}
		} else {
			return false;
		 	
		}

	}

}
