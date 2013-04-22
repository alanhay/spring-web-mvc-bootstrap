package uk.co.certait.spring.web.validator;

import static org.easymock.EasyMock.*;

import org.junit.Test;
import org.springframework.validation.Errors;

import uk.co.certait.spring.data.domain.PasswordDetails;

public class PasswordMatchValidatorTest {

	@Test
	public void testValidate() {
		PasswordMatchValidator validator = new PasswordMatchValidator();
		
		Errors errors = createMock(Errors.class);
		replay(errors);
		validator.validate(createPasswordDetails("AA", "AA"), errors);
		verify(errors);
		
		reset(errors);
		errors.rejectValue("password", "password.match.error");
		expectLastCall();
		replay(errors);
		validator.validate(createPasswordDetails("AA", "BB"), errors);

		verify(errors);
	}

	public PasswordDetails createPasswordDetails(final String password, final String passwordConfirmation) {
		return new PasswordDetails() {

			public String getPasswordConfirmation() {
				return password;
			}

			public String getPassword() {
				return passwordConfirmation;
			}
		};
	}
}
