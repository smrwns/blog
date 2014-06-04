package com.smrwns.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/main")
    public void main() {
        System.out.println("메인 컨트롤러 실행");
    }
    
}
