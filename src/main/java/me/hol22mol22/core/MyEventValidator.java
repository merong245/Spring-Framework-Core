package me.hol22mol22.core;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyEventValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MyEvent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","notempty","Empty title is not allowed");

    }
}
