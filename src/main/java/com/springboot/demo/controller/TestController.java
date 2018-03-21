package com.springboot.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello springboot";
    }

    @RequestMapping("/exception")
    @ResponseBody
    public String exception() throws Exception{
        throw new Exception("error");
    }

    @ApiOperation(value = "swagger",notes = "first swagger test")
    @ApiImplicitParam(name = "test")
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    public String swagger(){
        return "Hello swagger";
    }
}
