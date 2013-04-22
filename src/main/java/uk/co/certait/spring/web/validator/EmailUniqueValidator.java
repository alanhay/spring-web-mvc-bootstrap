package uk.co.certait.spring.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import uk.co.certait.spring.data.domain.User;
import uk.co.certait.spring.service.UserService;

@Component
public class EmailUniqueValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User edited = (User) object;
		User user = findByEmailAddress(edited.getEmailAddress());

		if (user != null && ! user.getId().equals(edited.getId())) {
			errors.rejectValue("emailAddress", "email.not.unique");
		}

	}

	public User findByEmailAddress(String emailAddress) {
		return userService.findByEmailAddress(emailAddress);
	}

	protected void setUserService(UserService userService) {
		this.userService = userService;
	}
}
