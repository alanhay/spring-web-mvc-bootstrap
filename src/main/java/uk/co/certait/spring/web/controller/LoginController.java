package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public/loadLogin.do")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadLogin() {
		return "public/login";
	}
	
	@ModelAttribute("tabName")
	public String getTabName(){
		return "Login";
	}
}
