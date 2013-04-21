package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uk.co.certait.spring.data.domain.User;

@Controller
@RequestMapping("/secure/admin/editUserDetails.do")
public class UserDetailsController extends AbstractUserDetailsController {

	@Override
	public String getFailurePath() {
		return "editUserDetails.do";
	}
	
	@Override
	public String getSuccessPath() {
		return "listUsers.do";
	}

	@ModelAttribute(value = "user")
	public User getUser(@RequestParam long userId) {
		return userService.findById(userId);
	}

	@ModelAttribute(value = "editMode")
	public boolean isEdit() {
		return true;
	}

	@ModelAttribute("tabName")
	public String getTabName() {
		return "Admin";
	}

	@ModelAttribute("legend")
	public String getLegend() {
		return "User Details";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		super.initBinder(binder);
		binder.setDisallowedFields(new String [] {"password", "passwordConfirmation"});
	}
}
