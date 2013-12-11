package edu.ucollege.tech;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ucollege.tech.OM.Person;
@Controller
@SessionAttributes("personObj") 
public class TeacherController {

	@RequestMapping(value = "/teach", method = RequestMethod.GET)
	public String teacher(ServletRequest request, Model model){
		if(isLoggedIn(request)){
			int ID = Integer.parseInt(request.getAttribute("AccountID").toString());
			try {
				model.addAttribute("students", new Person(ID, false).getStudents());
			} catch (Exception e) {
 				e.printStackTrace();
			}
			return "teach";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addStudent(ServletRequest request){
		if(isLoggedIn(request)){
			
			return "addStudent";
		}else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="/addStudentSubmit", method=RequestMethod.POST)
	public String addStudent(@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="class") String Class, @RequestParam(value="password") String password, ServletRequest request){
	
		if(isLoggedIn(request)){
			return "teach";
		}else {
			return "redirect:/";
		}
		
	}

	private boolean isLoggedIn(ServletRequest request){
		String cookie = request.getAttribute("AccountID").toString();
		//checking to see if the string is a number
		if(cookie.matches("\\d+") && !cookie.equals("0")){
			String role = request.getAttribute("Role").toString();
		 	if(role=="student"){
				return false;
			}else{
				return true;
			}
		} else {
			return false;
		 	
		}

	}
}
