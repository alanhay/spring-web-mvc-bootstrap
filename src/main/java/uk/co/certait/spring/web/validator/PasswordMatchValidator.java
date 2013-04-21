package uk.co.certait.spring.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import uk.co.certait.spring.data.domain.PasswordDetails;

@Component
public class PasswordMatchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PasswordDetails.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		PasswordDetails details = (PasswordDetails) object;

		if (details.getPassword() != null) {
			if (!details.getPassword().equals(details.getPasswordConfirmation())) {
				errors.rejectValue("password", "password.match.error");
			}
		}
	}
}
