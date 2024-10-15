package org.mvc.itvdnstudyspringmvc2.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookNameUniqueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BookNameUnique {

    String message() default "The book with this title already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
