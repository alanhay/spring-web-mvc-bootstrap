package uk.co.certait.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.co.certait.spring.data.domain.Gender;
import uk.co.certait.spring.data.domain.User;
import uk.co.certait.spring.service.UserRegistrationService;

@Controller
@RequestMapping("/public/register.do")
public class RegistrationController extends AbstractUserDetailsController {

	@Autowired
	private UserRegistrationService registrationService;

	@Override
	protected void onSuccess(User user) {
		registrationService.registerUser(user);
	}
	
	@Override
	public String getFailurePath() {
		return "register.do";
	}

	@Override
	public String getSuccessPath() {
		return "loadHome.do";
	}

	@ModelAttribute(value = "user")
	public User getUser() {
		User user = new User();
		user.setGender(Gender.M);

		return user;
	}

	@ModelAttribute("editMode")
	public boolean isEdit() {
		return false;
	}

	@ModelAttribute("tabName")
	public String getTabName() {
		return "Register";
	}

	@ModelAttribute("legend")
	public String getLegend() {
		return "Register";
	}
}
