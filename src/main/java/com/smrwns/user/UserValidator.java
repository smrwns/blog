package com.smrwns.user;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
        
        if(!StringUtils.hasText(user.getId())) errors.rejectValue("id", "user.addAction","ID는 필수 입력 항목입니다.");
        if(!StringUtils.hasText(user.getPasswd())) errors.rejectValue("passwd", "user.addAction", "PW는 필수 입력 항목입니다.");
        if(!StringUtils.hasText(user.getName())) errors.rejectValue("name", "user.addAction", "NAME은 필수 입력 항목입니다.");
        if(!StringUtils.hasText(user.getNick())) errors.rejectValue("nick", "user.addAction", "NICK은 필수 입력 항목입니다.");
        if(!StringUtils.hasText(user.getEmail())) errors.rejectValue("email", "user.addAction", "EMAIL은 필수 입력 항목입니다.");
        
            //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.addAction");        
    }

}
