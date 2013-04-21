package uk.co.certait.spring.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import uk.co.certait.spring.data.domain.Gender;
import uk.co.certait.spring.data.domain.User;
import uk.co.certait.spring.service.UserService;
import uk.co.certait.spring.web.validator.EmailUniqueValidator;
import uk.co.certait.spring.web.validator.PasswordMatchValidator;

@Controller
public abstract class AbstractUserDetailsController extends BaseController {

	@Autowired
	protected UserService userService;

	@Autowired
	private PasswordMatchValidator passwordMatchValidator;

	@Autowired
	private EmailUniqueValidator emailUniqueValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String loadUserDetailsForm() {
		return "public/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView saveUserDetails(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes ra) {
		RedirectView view;

		if (!isEdit()) {
			passwordMatchValidator.validate(user, result);
		}

		//userService.findByEmailAddress(user.getEmailAddress());
		
		emailUniqueValidator.validate(user, result);

		if (result.hasErrors()) {
			view = new RedirectView(getFailurePath());
			ra.addFlashAttribute(BINDING_RESULT_KEY + "user", result);
			ra.addFlashAttribute("user", user);
			ra.addFlashAttribute("userId", user.getId());
		}
		else {
			onSuccess(user);
			view = new RedirectView(getSuccessPath());
		}

		return view;
	}

	protected void onSuccess(User user) {
		user = userService.updateUser(user);
		
		if (user.getId() == getLoggedInUser().getId()) {
			reloadAuthenticatedUser(user);
		}
	}

	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		super.initBinder(binder);
		binder.setDisallowedFields(new String[] { "registrationDate" });
	}

	@ModelAttribute(value = "genders")
	public Gender[] getGenders() {
		return Gender.values();
	}

	public abstract String getFailurePath();

	public abstract String getSuccessPath();

	public abstract boolean isEdit();
}
