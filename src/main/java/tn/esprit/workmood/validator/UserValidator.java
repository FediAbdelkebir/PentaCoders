package tn.esprit.workmood.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tn.esprit.workmood.entities.User;
import tn.esprit.workmood.services.UserServiceInt;
@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserServiceInt us;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
		
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if ((user.getUsername().length()) < 6 || (user.getUsername().length() > 32)) {
            errors.rejectValue("username", "Size.user.username");
        }
        if (us.findUserByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwd", "NotEmpty");
        if (user.getPasswd().length() < 8 || user.getPasswd().length() > 32) {
            errors.rejectValue("passwd", "Size.user.password");
        }

        if (!user.getConfirmPasswd().equals(user.getPasswd())) {
            errors.rejectValue("confirmPasswd", "Diff.user.confirmPasswd");
        }
    }
		
	}


