package com.smrwns.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
    @RequestMapping(value="/account", method=RequestMethod.GET)
    public void view() {
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public void create() {
    }
    
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public void update() {
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public void delete() {
    }
    
}
