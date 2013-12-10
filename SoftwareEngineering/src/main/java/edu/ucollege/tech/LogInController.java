package edu.ucollege.tech;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.ucollege.tech.OM.Person;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("personObj") 
public class LogInController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="name") String name, @RequestParam(value="password") String password, HttpServletResponse response) {
		Person p = new Person();
		try{
			p.login(name, password);
		}catch(Exception e){
			System.out.println(e.toString());
			return "redirect:/";
		}
		if(p.isStudent()){
			response.addCookie(new Cookie("AccountID", "" + p.getID()));
			response.addCookie(new Cookie("Role", "student"));
			return "redirect:/student";
		}else { //they are teacher
			response.addCookie(new Cookie("AccountID","" + p.getID()));
			response.addCookie(new Cookie("AccountID", "teacher"));
			return "redirect:/teacher";
		}
	}
	
}
