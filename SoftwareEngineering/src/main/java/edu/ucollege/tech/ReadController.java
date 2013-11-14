package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ucollege.tech.Connections.MySQL;

@Controller
public class ReadController {
	MySQL database = new MySQL();
	@RequestMapping(value = "/Read")
	public String Read(){
		return "Read";
	}
	@RequestMapping(value = "/Read/Articles")
	public String Articles(){
		return database.getArticles();
	}
}
