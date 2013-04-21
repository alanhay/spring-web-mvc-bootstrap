package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public/loadAccessDenied.do")
public class AccessDeniedController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadAccessDenied(){
		return "public/accessDenied";
	}
}
