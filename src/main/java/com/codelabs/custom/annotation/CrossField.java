package com.codelabs.custom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.codelabs.custom.validator.CrossFieldValidator;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CrossFieldValidator.class)
public @interface CrossField {
	String message() default "Invalid field";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    
    //below two fields can be used to check two dependent values if they match or not
    String fieldToValiate() default "";
    String fieldToValiateAgainst() default "";
    
    String code();
    
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
    	CrossField[] value();
    }
}

/*	This is an exmaple how to use above annotation to validate two fields
 * @FieldsValueMatch.List({
 * 
 * @FieldsValueMatch( field = "password", fieldMatch = "verifyPassword", message
 * = "Passwords do not match!" ),
 * 
 * @FieldsValueMatch( field = "email", fieldMatch = "verifyEmail", message =
 * "Email addresses do not match!" ) })
 */