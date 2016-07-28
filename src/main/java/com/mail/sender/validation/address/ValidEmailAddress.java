package com.mail.sender.validation.address;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmailAddressConstraint.class)
public @interface ValidEmailAddress {

    String message() default "Invalid email address.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

