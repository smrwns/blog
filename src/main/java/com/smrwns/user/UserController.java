package com.smrwns.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.smrwns.model.User;
import com.smrwns.view.UserAddConfirm;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    private UserAddConfirm userAddConfirm;

    
    /**
     * 유저 정보 보기
     * @param userId
     */
    @RequestMapping(value= {"/{userId}/view"}, method={RequestMethod.GET})
    public ModelAndView getUser(@PathVariable("userId") String id) {
        
        User userInfo = userService.getUser(id);
        System.out.println(id);
//        System.out.println(userInfo.getType());
        
        ModelAndView mav = new ModelAndView("/user/view");
        mav.addObject("userInfo", userInfo);
        
        return mav;
    }
    
    
    /**
     *  유저 추가
     */
    @RequestMapping(value= {"/add"}, method={RequestMethod.GET})
    public void addForm(Model model) {
        User user = new User();
        user.setType("1");
        
        model.addAttribute("user", user);
        System.out.println("유저 등록 폼 페이지를 출력하기 전에 관련 작업 완료");
    }

    @RequestMapping(value= {"/add"}, method={RequestMethod.POST})
    public ModelAndView addAction(User user, Model model, BindingResult bindingResult, SessionStatus session) {
        
        new UserValidator().validate(user, bindingResult);

        if(bindingResult.hasErrors()) {
            return new ModelAndView("/user/add");
        }
        else {
            session.setComplete();

            System.out.println(user);
            //TODO : 유저 등록 액션
            User addedUser = userService.add(user);
            
            
            
            System.out.println("유저 등록 폼에서 전송된 데이터를 저장하는 액션");
            

            model.addAttribute("msg", "등록이 완료되었습니다.");
            model.addAttribute("href", "/main");
            model.addAttribute("userId", user.getId());
            
            userAddConfirm = new UserAddConfirm();

            return new ModelAndView(userAddConfirm, model.asMap());
        }
    }
    
    
    /**
     * 유저 정보 업데이트
     */
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.GET})
    public ModelAndView updateForm(@PathVariable("userId") String userId) {
        System.out.println("유저 정보를 조회");

        User userInfo = new User();
        //dummy data
        userInfo.setId("smrwns");
        userInfo.setPasswd("xxxx");
        userInfo.setName("최성균");
        userInfo.setType("1");
        userInfo.setGroup("smrwns");
        userInfo.setEmail("smrwns@smrwns.com");
        
        ModelAndView mav = new ModelAndView("/user/update");
        mav.addObject("userInfo", userInfo);
        
        System.out.println("유저 정보 업데이트 폼 출력 페이지");
        
        return mav;
    }
    
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.PUT})
    public ModelAndView updateAction(@PathVariable("userId") String userId, User user, Model model) {
        System.out.println("유저 정보 업데트 폼에서 전송한 데이터를 저장하는 액션");
        System.out.println(user.getId());
        
        model.addAttribute("msg", "수정을 완료하였습니다.");
        model.addAttribute("href", "/user/"+user.getId()+"/view");
        
        ModelAndView mav = new ModelAndView("/user/confirm");
        mav.addObject("confirmInfo", model);
        
        return mav;
    }
    
    /**
     * 유저 삭제
     */
    @RequestMapping(value= {"/{userId}/remove"}, method={RequestMethod.POST})
    public ModelAndView remove(@PathVariable("userId") String userId, String passwd, Model model) {
        System.out.println(userId);
        System.out.println(passwd);
        System.out.println("유저 삭제");
        System.out.println("완료");
        
        model.addAttribute("msg", "유저 삭제를 완료하였습니다.");
        model.addAttribute("href", "/main");
        
        ModelAndView mav = new ModelAndView("/user/confirm");
        mav.addObject("confirmInfo", model);
        
        return mav;
    }
    
}