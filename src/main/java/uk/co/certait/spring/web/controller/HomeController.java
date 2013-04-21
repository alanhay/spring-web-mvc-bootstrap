package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*/loadHome.do")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadHome() {
		return "public/home";
	}
	
	@ModelAttribute("tabName")
	public String getTabName(){
		return "Home";
	}
}
