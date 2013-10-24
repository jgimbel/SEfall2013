package edu.ucollege.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReadController {

	@RequestMapping(value = "/Read")
	public String Read(){
		return "Read";
	}
}
