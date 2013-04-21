package uk.co.certait.spring.web.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import uk.co.certait.spring.data.validation.EmailExists;
import uk.co.certait.spring.service.ResetPasswordService;
import uk.co.certait.spring.service.UserNotFoundException;

@Controller
@RequestMapping("/public/resetPassword.do")
public class ResetPasswordController extends BaseController{

	@Autowired
	private ResetPasswordService resetPasswordService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadResetPasswordForm() {
		return new ModelAndView("public/resetPassword");
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView resetPassword(@Valid @ModelAttribute ResetPasswordForm form, BindingResult result, RedirectAttributes ra) {

		RedirectView view = new RedirectView("resetPasswordConfirmation.do");

		if (!result.hasErrors()) {
			try {
				resetPasswordService.resetUserPassword(form.getEmailAddress());
			}
			catch (UserNotFoundException ex) {
				//result.rejectValue("emailAddress", "ResetPassword.invalid.email.address");
			}
		}

		if (result.hasErrors()) {
			view = new RedirectView("resetPassword.do");
			ra.addFlashAttribute(BINDING_RESULT_KEY + "resetPasswordForm", result);
			ra.addFlashAttribute("resetPasswordForm", form);
		}

		return view;
	}

	@ModelAttribute(value = "resetPasswordForm")
	public ResetPasswordForm getPasswordForm() {
		return new ResetPasswordForm();
	}

	public class ResetPasswordForm {

		@NotEmpty
		@EmailExists
		private String emailAddress;

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
	}
}
