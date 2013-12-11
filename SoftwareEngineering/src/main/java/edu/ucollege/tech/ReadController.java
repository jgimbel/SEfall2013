package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.ucollege.tech.OM.Article;

@Controller
public class ReadController {
	@RequestMapping(value = "/Read")
	public String Read(){
		return "Read";
	}
	@RequestMapping(value = "/Read/article", method = RequestMethod.POST)
	public String Articles(@RequestParam String title, @RequestParam String url){
		
	new Article(url, title).save();
		return "redirect:/library";
	}
}
