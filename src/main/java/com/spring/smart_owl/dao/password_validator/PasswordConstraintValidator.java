package com.spring.smart_owl.dao.password_validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword arg0) {
    }

    public boolean isValid(String password, ConstraintValidatorContext context) {
        //PasswordValidator validator = new P


        return false;
    }
}
