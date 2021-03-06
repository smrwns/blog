package com.smrwns.modules.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = {"/main"}, method = {RequestMethod.GET})
    public String main() {
        logger.info("main page loading");
        return "tiles-main";
    }
    

}
