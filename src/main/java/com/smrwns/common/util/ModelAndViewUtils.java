package com.smrwns.common.util;

import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewUtils {

    private ModelAndViewUtils() {
    }

    public static final String ATTR_NAME_ERRMESSAGE = "errMessage";
    public static final String ATTR_NAME_RESULT = "result";
    public static final String ATTR_VALUE_SUCCESS = "success";
    public static final String ATTR_VALUE_FAILURE = "failure";

    public static ModelAndView jsonWithError(String errMessage) {
        return new ModelAndView("jsonView").addObject(ATTR_NAME_RESULT, ATTR_VALUE_FAILURE).addObject(ATTR_NAME_ERRMESSAGE, errMessage);
    }

    public static ModelAndView jsonWithSuccessResult() {
        return new ModelAndView("jsonView").addObject(ATTR_NAME_RESULT, ATTR_VALUE_SUCCESS);
    }

    public static ModelAndView redirect(String msg, String href) {
        return new ModelAndView("/redirect").addObject("msg", msg).addObject("href", href);
    }

}
