package kr.jay.appmain.endpoint.common.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {
	Class<? extends Enum<?>> enumClass();

	String message() default "must be any of enum {enumClass}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}