package com.springboot.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "/upload.html";
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

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request,

                             @RequestParam("file") MultipartFile file){
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "success";
        } else {
            return "error";
        }

    }
}
