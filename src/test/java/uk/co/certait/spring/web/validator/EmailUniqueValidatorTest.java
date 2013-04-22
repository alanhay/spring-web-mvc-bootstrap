package uk.co.certait.spring.web.validator;

import static org.easymock.EasyMock.*;

import org.junit.Test;
import org.springframework.validation.Errors;

import uk.co.certait.spring.data.domain.User;
import uk.co.certait.spring.service.UserService;

public class EmailUniqueValidatorTest {

	@Test
	public void testValidate() {
		EmailUniqueValidator validator = new EmailUniqueValidator();
		validator.setUserService(createUserService(createUser(new Long(1), "alan@test.net")));
		Errors errors = createMock(Errors.class);
		replay(errors);

		validator.validate(createUser(new Long(1), "alan@test.net"), errors);
		verify(errors);

		reset(errors);
		validator.setUserService(createUserService(createUser(new Long(1), "alan@test.net")));
		errors.rejectValue("emailAddress", "email.not.unique");
		expectLastCall();
		replay(errors);
		validator.validate(createUser(new Long(2), "alan@test.net"), errors);
		verify(errors);
		
		reset(errors);
		validator.setUserService(createUserService(null));
		replay(errors);
		validator.validate(createUser(new Long(2), "alan@test.net"), errors);
		verify(errors);
	}

	public UserService createUserService(final User user) {
		UserService service = createMock(UserService.class);
		expect(service.findByEmailAddress((String) notNull())).andReturn(user);
		replay(service);

		return service;
	}

	public User createUser(final long id, final String emailAddress) {
		User user = new User() {
			public Long getId() {
				return id;
			}
		};

		user.setEmailAddress(emailAddress);

		return user;
	}
}
