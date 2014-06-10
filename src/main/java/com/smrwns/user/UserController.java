package com.smrwns.user;

import javax.servlet.http.HttpServletRequest;

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

    
    /*****************
     * 유저 정보 반환
     *****************/
    @RequestMapping(value= {"/{userId}/view"}, method={RequestMethod.GET})
    public ModelAndView getUser(@PathVariable("userId") String userId) {
        
        //TEST
        //System.out.println("URL : " +request.getRequestURL());
        //System.out.println("URI : " +request.getRequestURI());
        
        //우선, 보기 편해서 if문 대신에 try를 썼음.
        try {
            User user = userService.getUser(userId);
            ModelAndView mav = new ModelAndView("/user/view");
            mav.addObject("user", user);
            
            return mav;
        } 
        catch (NullPointerException ne) {
            ne.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null; //TODO : err page
    }
    
    /*********************
     *  유저 추가 폼 설정 
     *********************/
    @RequestMapping(value= {"/add"}, method={RequestMethod.GET})
    public void addForm(Model model) {

        User user = new User();
        user.setType("1");
        model.addAttribute("user", user);
        
    }

    /*******************************************
     * 유저 추가 폼에서 전달된 유저 객체를 추가
     *******************************************/
    @RequestMapping(value= {"/add"}, method={RequestMethod.POST})
    public ModelAndView addAction(User user, Model model, BindingResult bindingResult, SessionStatus session) {
        
        new UserValidator().validate(user, bindingResult);

        if(bindingResult.hasErrors()) {
            return new ModelAndView("/user/add");
        }
        else {
            session.setComplete();
            
            User addedUser = userService.add(user);
            userAddConfirm = new UserAddConfirm();
            
            try {
                model.addAttribute("msg", "등록이 완료되었습니다.");
                model.addAttribute("href", "/main");
                model.addAttribute("addedUser", addedUser);
                return new ModelAndView(userAddConfirm, model.asMap());
            } 
            catch (NullPointerException ne) {
                ne.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
            return null;    //TODO : err page
        }
    }
    
    
    /********************
     * 유저 수정 폼 설정
     ********************/
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.GET})
    public ModelAndView updateForm(@PathVariable("userId") String userId) {
        
        ModelAndView model = getUser(userId);
        User user = (User) model.getModel();
        
        System.out.println(user);
        
        ModelAndView mav = new ModelAndView("/user/update");
        mav.addObject("user", user);
        
        return mav;
    }

    /*******************************************
     * 유저 수정 폼에서 전달된 유저 객체를 추가
     *******************************************/
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.PUT})
    public ModelAndView updateAction(@PathVariable("userId") String userId, User user, Model model) {
        
        try {
            User updatedUser = userService.update(user);
            model.addAttribute("msg", "수정을 완료하였습니다.");
            model.addAttribute("href", "/user/"+user.getId()+"/view");
            ModelAndView mav = new ModelAndView("/user/confirm");
            mav.addObject("confirmInfo", model);
            mav.addObject("updatedUser", updatedUser);
            return mav;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    /************
     * 유저 삭제
     ************/
    @RequestMapping(value= {"/{userId}/delete"}, method={RequestMethod.POST})
    public ModelAndView delete(@PathVariable("userId") String userId, String passwd, Model model) {
        //TODO : login 확인
        
        int delCheck = userService.delete(userId, passwd);

        model.addAttribute("msg", "유저 삭제를 완료하였습니다.");
        model.addAttribute("href", "/main");
        
        ModelAndView mav = new ModelAndView("/user/confirm");
        mav.addObject("confirmInfo", model);
        
        return mav;
    }

    
    //TODO : 그룹에서 유저 제거 (remove)
}