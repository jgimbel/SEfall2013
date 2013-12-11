package edu.ucollege.tech;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucollege.tech.Connections.MySQL;
import edu.ucollege.tech.OM.Article;
import edu.ucollege.tech.OM.Review;

@Controller
public class ReadController {
	
	@RequestMapping(value = "/Read/{id}")
	public String ReadArticle(@PathVariable int id, Model model, ServletRequest request){
		if(isLoggedIn(request)){
			Review r = new Review(Integer.parseInt(request.getAttribute("AccountID").toString()), id);
			model.addAttribute("review", r);
			return "Read";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="Read/{id}/Save", method=RequestMethod.POST)
	public String SaveArticle(ServletRequest request, @PathVariable int id, @RequestParam(value="notes") String notes, @RequestParam(value="review") String review){	
		if(isLoggedIn(request)){
			Review r = new Review(Integer.parseInt(request.getAttribute("AccountID").toString()), id, notes, review);
			r.Save();
			return "It worked perfectly!";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/Read/article", method = RequestMethod.POST)
	public String Articles(@RequestParam String title, @RequestParam String url, @RequestParam int Class){
		new Article(url, title, Class).save();
		return "redirect:/library";
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
