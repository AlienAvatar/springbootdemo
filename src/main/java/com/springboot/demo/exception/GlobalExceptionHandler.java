package com.springboot.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)//类字面常量 反射
    public ModelAndView defaultError(HttpServletRequest req,Exception e) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",req.getRequestURI());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }


}
