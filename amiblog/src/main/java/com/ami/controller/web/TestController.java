package com.ami.controller.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hei")
    public String hi(String str){

        return "你好："+str;
    }
}
