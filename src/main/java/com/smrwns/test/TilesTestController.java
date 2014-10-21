package com.smrwns.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/tiles")
public class TilesTestController {

    
    @RequestMapping(value = "/navibar", method=RequestMethod.GET)
    public String navibar() {
        return "navibar";
    }
    
    @RequestMapping(value = "/city", method=RequestMethod.GET)
    public String city() {
        return "city";
    }
}
