package com.smrwns.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smrwns.domains.MongoTestUser;

@Controller
@RequestMapping("/mongo")
public class MongoTestUsersController {

    @Autowired
    private MongoTestUsersService userService;
    
    @RequestMapping(value = "/getUserName/{id}", method=RequestMethod.GET)
    public String getName(@PathVariable("id") String id) {
        MongoTestUser user = userService.findOne(id);
        return "";
    }
}
