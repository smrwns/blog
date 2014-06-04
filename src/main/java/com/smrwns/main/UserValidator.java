package com.smrwns.main;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.smrwns.model.User;

public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
        //return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        User user = (User) target;

        //TODO : user객체의 name이 비어 있으면 err
        if(!StringUtils.hasText(user.getName()))
            //field, errorCode, defaultMessage
            errors.rejectValue("name", "user.addAction", "이름이 비어있습니다.");    //error count 1
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.addAction");        
    }

}
