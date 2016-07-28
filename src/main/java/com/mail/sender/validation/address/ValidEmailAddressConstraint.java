package com.mail.sender.validation.address;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailAddressConstraint implements ConstraintValidator<ValidEmailAddress, String> {

    @Override
    public void initialize(ValidEmailAddress constraintAnnotation) {

    }

    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext context) {
        return EmailValidator.getInstance().isValid(emailAddress);
    }

}
