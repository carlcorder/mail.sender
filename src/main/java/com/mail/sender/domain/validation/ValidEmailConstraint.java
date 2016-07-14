package com.mail.sender.domain.validation;

import com.mail.sender.domain.Email;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class ValidEmailConstraint implements ConstraintValidator<ValidEmail, Email> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(Email email, ConstraintValidatorContext context) {
        return EmailValidator.getInstance().isValid(email.getTo()) &&
                !StringUtils.isEmpty(email.getSubject());
    }

}
