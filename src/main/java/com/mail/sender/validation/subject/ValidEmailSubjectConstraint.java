package com.mail.sender.validation.subject;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailSubjectConstraint implements ConstraintValidator<ValidEmailSubject, String> {

    @Override
    public void initialize(ValidEmailSubject constraintAnnotation) {

    }

    @Override
    public boolean isValid(String emailSubject, ConstraintValidatorContext context) {
        return !StringUtils.isEmpty(emailSubject);
    }

}

