package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ucollege.tech.Connections.MySQL;

@Controller
public class ReadController {
	MySQL database = new MySQL();
	
	@RequestMapping(value = "/Read")
	public String Read(){
		return "Read";
	}
	@RequestMapping(value = "/Read/Articles")
	public String Articles(@RequestParam int ClassID){
		return null;
		//return database.getArticles(ClassID);
	}
}
