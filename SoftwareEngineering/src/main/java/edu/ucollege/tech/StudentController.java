package edu.ucollege.tech;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ucollege.tech.OM.Person;
@Controller
@SessionAttributes("personObj") 
public class StudentController {
	
	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String student(ServletRequest request, Model model){
		if(isLoggedIn(request)){
			int ID = Integer.parseInt(request.getAttribute("AccountID").toString());
			try {
				Person p = new Person(ID, false);
				model.addAttribute("library", p.getLibrary());
				model.addAttribute("classes", p.getClasses());
				
			} catch (Exception e) {
 				e.printStackTrace();
			}
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
