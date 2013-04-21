package uk.co.certait.spring.web.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure/loadSecure.do")
public class SecureController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadHome(){
		return new ModelAndView("secure/secure");
	}
	
	@ModelAttribute("tabName")
	public String getTabName(){
		return "Secure";
	}
}
