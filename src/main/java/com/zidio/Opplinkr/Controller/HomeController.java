package com.zidio.Opplinkr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	 @GetMapping("/")
	    public String index() {
	        return "index";  // will look for index.html in /templates
	    }
}
