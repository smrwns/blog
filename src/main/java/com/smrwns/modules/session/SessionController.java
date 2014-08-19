package com.smrwns.modules.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/session")
public class SessionController {
    
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(HttpServletRequest req) {
        return "session/add";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public void add(
            HttpSession httpSession,
            @RequestParam(value="attributeName", required=false) String attributeName,
            @RequestParam(value="attributeValue", required=false) String attributeValue) {
        httpSession.setAttribute(attributeName, attributeValue);
    }

}