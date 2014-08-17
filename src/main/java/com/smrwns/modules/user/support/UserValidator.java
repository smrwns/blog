package com.smrwns.modules.user.support;

import com.smrwns.domains.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        if (!StringUtils.hasText(user.getPassword())) errors.rejectValue("passwd", "user.addAction", "PW는 필수 입력 항목입니다.");
        if (!StringUtils.hasText(user.getName())) errors.rejectValue("name", "user.addAction", "NAME은 필수 입력 항목입니다.");
        if (!StringUtils.hasText(user.getUsername())) errors.rejectValue("nick", "user.addAction", "NICK은 필수 입력 항목입니다.");
        if (!StringUtils.hasText(user.getEmail())) errors.rejectValue("email", "user.addAction", "EMAIL은 필수 입력 항목입니다.");

    }

}
