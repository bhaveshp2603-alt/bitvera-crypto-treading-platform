package com.bhavesh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "Welcome to Crypto Trading platform";
    }

    @GetMapping("/api")
    public String Secure(){
        return "Welcome to Crypto Trading platform Secure";
    }
}
