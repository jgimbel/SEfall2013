package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucollege.tech.Connections.MySQL;

@Controller
public class ReadController {
	MySQL database = new MySQL();
	
	@RequestMapping(value = "/Read")
	public String Read(){
		return "Read";
	}
	
	@RequestMapping(value = "/addArticle", method=RequestMethod.POST)
	public String Articles(@RequestParam String title, @RequestParam String url){
		
		return null;
		
	}
}
