package com.mail.sender.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmailConstraint.class)
public @interface ValidEmail {

    String message() default "failed to send : invalid email";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

