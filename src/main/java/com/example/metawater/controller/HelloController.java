package com.example.metawater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/detail")
    public String detail(){
        return "detail";
    }
}
