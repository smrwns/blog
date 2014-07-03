package com.smrwns.modules.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smrwns.domains.User;

@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;
    
    public boolean login(String userId, String passwd) {
        User user = loginMapper.login();
        
        if(user != null) {
            return true;
        }
        else {
            return false;
        }
    }

}
