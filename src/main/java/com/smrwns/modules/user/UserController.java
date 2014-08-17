package com.smrwns.modules.user;

import com.smrwns.common.util.ModelAndViewUtils;
import com.smrwns.domains.User;
import com.smrwns.modules.user.support.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 유저 정보 반환
     */
    @RequestMapping(value = {"/{userId}/view"}, method = {RequestMethod.GET})
    public String getUser(@PathVariable("userId") String userId, Model model) {

        User user = userService.getById(userId);
        model.addAttribute("user", user);

        return "/user/view";
    }

    /**
     * 유저 추가폼 설정
     */
    @RequestMapping(value = {"/add"}, method = {RequestMethod.GET})
    public String addForm(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "/user/add";
    }

    /**
     * 유저 추가 폼에서 전달 받은 유저 객체를 추가
     */
    @RequestMapping(value = {"/add"}, method = {RequestMethod.POST})
    public ModelAndView addAction(User user, Model model, BindingResult bindingResult, SessionStatus session) {

        new UserValidator().validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/user/add");
        }
        else {
            userService.insert(user);
            session.setComplete();
            return ModelAndViewUtils.redirect("등록이 완료되었습니다.", "/main");
        }
    }

    /**
     * 유저 수정폼 설정
     */
    @RequestMapping(value = {"{userId}/update"}, method = {RequestMethod.GET})
    public String updateForm(@PathVariable("userId") String userId, Model model) {

        User user = userService.getById(userId);
        model.addAttribute("user", user);

        return "/user/update";
    }

    /**
     * 유저 수정폼에서 전달 받은 객체로 업데이트
     */
    @RequestMapping(value = {"{userId}/update"}, method = {RequestMethod.PUT})
    public ModelAndView updateAction(@PathVariable("userId") String userId, User user, Model model, BindingResult bindingResult, SessionStatus session) {

        new UserValidator().validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/user/update");
        }
        else {
            userService.update(user);
            session.setComplete();
            return ModelAndViewUtils.redirect("수정을 완료하였습니다.", "/user/" + userId + "/view");
        }

    }

    /**
     * 유저 제거
     */
    @RequestMapping(value = {"/{userId}/remove"}, method = {RequestMethod.POST})
    public ModelAndView remove(@PathVariable("userId") String userId, String passwd, Model model) {

        logger.info("유저삭제\nid : {}, passwd : {}", userId, passwd);

        return ModelAndViewUtils.redirect("유저 제거를 완료하였습니다.", "/main");
    }

}