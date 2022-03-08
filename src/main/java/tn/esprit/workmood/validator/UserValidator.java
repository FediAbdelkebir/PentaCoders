package tn.esprit.workmood.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Pattern patern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = patern.matcher(user.getEmailAddress());

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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "enabled", "NotEmpty");
        if (user.isEnabled()!= true) {
            errors.rejectValue("enabled", "enable account!");
        }
        
        if (matcher.find()==false) {
            errors.rejectValue("emailAddress", "EmailAddress.not.valid");
        }
        if (us.findUserByEmailAddress(user.getEmailAddress()) != null) {
            errors.rejectValue("emailAddress", "Duplicate.emailAddress");
        }

        if (!user.getConfirmPasswd().equals(user.getPasswd())) {
            errors.rejectValue("confirmPasswd", "Diff.user.confirmPasswd");
        }
    }
		
	}


