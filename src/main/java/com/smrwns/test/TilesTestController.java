package com.smrwns.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/tiles")
public class TilesTestController {

    @RequestMapping(value = "/test", method=RequestMethod.GET)
    public String city() {
        return "common/template/tiles/city/city";
    }
}
