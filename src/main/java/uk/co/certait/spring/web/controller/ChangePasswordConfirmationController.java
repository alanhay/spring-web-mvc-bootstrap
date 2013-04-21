package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure/changePasswordConfirmation.do")
public class ChangePasswordConfirmationController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadResetPasswordConfirmation() {
		return "secure/changePasswordConfirmation";
	}
}
