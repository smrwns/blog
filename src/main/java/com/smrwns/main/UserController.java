package com.smrwns.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.smrwns.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
//    @Autowired
//    private RedirectView redirectView;

    
    //사용되어질 라이브러리에 따라 선택
    //ex. cglib(고성능 프록시 라이브러리 생성자 2번씩 읽음.)
//    public UserController() {
//        redirectView = new RedirectView();
//    }

    private RedirectView redirectView;
    
    @PostConstruct
    public void setup() {
        redirectView = new RedirectView();
    }
    

    @RequestMapping(value={"/test"}, method = {RequestMethod.GET})
    public void test1(@RequestParam(value="key", required=true, defaultValue="123") String key) {
        System.out.println("@RequestParam : " + key);
    }

    @RequestMapping(value={"/test/{key}"}, method = {RequestMethod.GET})
    public void test2(@PathVariable("key") String key) {
        System.out.println("@PathVariable");
    }

    /**
     * 유저 추가
     */
    @RequestMapping(value= {"/add"}, method={RequestMethod.GET})
    public void addForm(Model model) {
        User user = new User();
        user.setType("1");
        
        model.addAttribute("user", user);
        System.out.println("유저 등록 폼 출력 페이지");
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
            System.out.println("유저 등록 폼에서 전송된 데이터를 저장하는 액션");
//            return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/user/smrwns";
            
            model.addAttribute("msg", "저장되었습니다.");
//            model.addAttribute("href", "/user/smrwns");
//            return new ModelAndView("/redirect");
            return new ModelAndView(redirectView, model.asMap());
        }
    }
    
    /**
     * 유저 정보 보기
     * @param userId
     */
    @RequestMapping(value= {"/{userId}"}, method={RequestMethod.GET})
    public void view(@PathVariable("userId") String userId) {
        System.out.println("유저 보기 폼 출력 페이지");
    }
    
    /**
     * 유저 정보 업데이트
     */
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.GET})
    public void updateForm(@PathVariable("userId") String userId) {
        System.out.println("유저 정보 업데이트 폼 출력 페이지");
    }
    @RequestMapping(value= {"{userId}/update"}, method={RequestMethod.PUT})
    public void updateAction(@PathVariable("userId") String userId) {
        System.out.println("유저 정보 업데트 폼에서 전송한 데이터를 저장하는 액션");
    }
    
    /**
     * 유저 삭제
     */
    @RequestMapping(value= {"/{userId}/remove"}, method={RequestMethod.POST})
    public void remove(@PathVariable("userId") String userId) {
        System.out.println("유저 삭제");
    }
    
}