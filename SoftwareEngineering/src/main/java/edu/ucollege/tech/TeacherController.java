package edu.ucollege.tech;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ucollege.tech.Connections.MySQL;
import edu.ucollege.tech.OM.Person;
@Controller
@SessionAttributes("personObj") 
public class TeacherController {

	@RequestMapping(value = "/teach", method = RequestMethod.GET)
	public String teacher(ServletRequest request, Model model, @RequestParam(value="class", defaultValue="0", required=false) int c){
		if(isLoggedIn(request)){
			int ID = Integer.parseInt(request.getAttribute("AccountID").toString());
			try {
				Person p = new Person(ID, false);
				model.addAttribute("students", p.getStudents(c));
				model.addAttribute("classes", p.getClasses());
			} catch (Exception e) {
 				e.printStackTrace();
			}
			return "teach";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String addStudent(ServletRequest request, Model model){
		if(isLoggedIn(request)){
			int ID = Integer.parseInt(request.getAttribute("AccountID").toString());
			try {
				Person p = new Person(ID, false);
				model.addAttribute("classes", p.getClasses());
			} catch (Exception e) {
 				e.printStackTrace();
			}
			
			return "addStudent";
		}else {
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value="/addStudentSubmit", method=RequestMethod.POST)
	public String addStudent(ServletRequest request, @RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="class") int c, @RequestParam(value="usermail") String Email, @RequestParam(value="password") String password){
		
		if(isLoggedIn(request)){
			Person p = new Person(firstName, lastName, Email, password);
			p.Save();
			new MySQL().addToRoster(Integer.parseInt(request.getAttribute("AccountID").toString()), p.getID(), c);
			return "redirect:/teach";
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
