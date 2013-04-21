package uk.co.certait.spring.web.controller.secure.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure/admin/loadAdmin.do")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadHome(){
		return new ModelAndView("secure/admin/admin");
	}
	
	@ModelAttribute("tabName")
	public String getTabName(){
		return "Admin";
	}
}
