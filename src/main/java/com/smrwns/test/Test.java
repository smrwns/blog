package com.smrwns.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class Test {

    @RequestMapping(value="/aj1", method=RequestMethod.GET)
    public String angularJsTest() {
        return "z_test/angularjs/test4";
    }

    @RequestMapping(value="/aj2", method=RequestMethod.GET)
    public String angularJsTest2() {
        return "z_test/angularjs/test5";
    }
    
    
}
