package com.smrwns.modules.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request, Model model) {
        
        return null;
        
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView loginAction(HttpServletRequest request) {

        Boolean loginSuccess = false;

        String userId = request.getParameter("userId");
        String passwd = request.getParameter("passwd");

        loginSuccess = loginService.login(userId, passwd);

        if(loginSuccess) {
            //로그인 성공
            try {
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("passwd", passwd);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            //로그인 실패
        }
        
        ModelAndView mav = new ModelAndView();
        
        return null;
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logoutAction(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
}