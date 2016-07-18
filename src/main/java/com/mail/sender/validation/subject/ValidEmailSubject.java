package com.mail.sender.validation.subject;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE,TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmailSubjectConstraint.class)
public @interface ValidEmailSubject {

    String message() default "Subject must not be empty.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}


