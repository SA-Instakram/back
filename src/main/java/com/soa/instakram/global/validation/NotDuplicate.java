package com.soa.instakram.global.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicateValidator.class)
public @interface NotDuplicate {
    String target() default "";
    String message() default "";
    Class[] groups() default {};
    Class[] payload() default {};
}
