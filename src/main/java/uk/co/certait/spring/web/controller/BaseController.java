package uk.co.certait.spring.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import uk.co.certait.spring.data.domain.User;

public class BaseController {

	protected static final String BINDING_RESULT_KEY = "org.springframework.validation.BindingResult.";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.registerCustomEditor(Date.class, new DatePropertyEditor());
		// we can also declare as application wide in xml
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	protected User getLoggedInUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	protected void reloadAuthenticatedUser(User user){
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);	
	}
}
