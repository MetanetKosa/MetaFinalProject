package com.example.metawater.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JacocoController {
    @GetMapping("/test")
    public String test(@RequestParam int n){

        if(n >= 0){
            return "hello";
        }else{
            return "world";
        }
    }
}
