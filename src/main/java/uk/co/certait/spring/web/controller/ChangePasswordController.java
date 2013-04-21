package uk.co.certait.spring.web.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import uk.co.certait.spring.data.domain.PasswordDetails;
import uk.co.certait.spring.data.domain.User;
import uk.co.certait.spring.service.UserService;
import uk.co.certait.spring.service.util.BCryptPasswordEncoder;
import uk.co.certait.spring.web.validator.PasswordMatchValidator;

@Controller
@RequestMapping("/secure/changePassword.do")
public class ChangePasswordController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	PasswordMatchValidator passwordMatchValidator;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public String loadPasswordForm() {
		return "secure/changePassword";
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView updatePassword(@Valid @ModelAttribute PasswordForm form, BindingResult result, RedirectAttributes ra) {
		RedirectView view = new RedirectView("changePasswordConfirmation.do");

		passwordMatchValidator.validate(form, result);

		if (!result.hasErrors()) {
			User user = getLoggedInUser();
			user.setPassword(passwordEncoder.encodePassword(form.getPassword(), null));
			user = userService.updateUser(user);
			reloadAuthenticatedUser(user);
		}
		else {
			view = new RedirectView("changePassword.do");
			ra.addFlashAttribute(BINDING_RESULT_KEY + "passwordForm", result);
			ra.addFlashAttribute("passwordForm", form);
		}

		return view;
	}

	@ModelAttribute(value = "passwordForm")
	public PasswordForm getPasswordForm() {
		return new PasswordForm();
	}

	@ModelAttribute("tabName")
	public String getTabName() {
		return "MyAccount";
	}

	public class PasswordForm implements PasswordDetails {

		@NotEmpty
		@Length(min = 8)
		private String password;

		@NotEmpty
		private String passwordConfirmation;

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}
	}
}
