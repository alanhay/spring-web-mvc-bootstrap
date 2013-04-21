package uk.co.certait.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.co.certait.spring.data.domain.User;

@Controller
@RequestMapping("/secure/editMyDetails.do")
public class MyDetailsController extends AbstractUserDetailsController {

	@Override
	public String getFailurePath() {
		return "editMyDetails.do";
	}

	@Override
	public String getSuccessPath() {
		return "loadHome.do";
	}

	@ModelAttribute(value = "user")
	public User getUser() {
		return getLoggedInUser();
	}

	@ModelAttribute("editMode")
	public boolean isEdit() {
		return true;
	}

	@ModelAttribute("tabName")
	public String getTabName() {
		return "MyAccount";
	}

	@ModelAttribute("legend")
	public String getLegend() {
		return "My Details";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		super.initBinder(binder);
		binder.setDisallowedFields(new String [] {"password", "passwordConfirmation"});
	}
}
