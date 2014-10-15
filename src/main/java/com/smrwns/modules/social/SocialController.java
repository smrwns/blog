package com.smrwns.modules.social;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/social")
public class SocialController {

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String SocialHome(Model model) {
        return "social/home";
    }
    
    
}