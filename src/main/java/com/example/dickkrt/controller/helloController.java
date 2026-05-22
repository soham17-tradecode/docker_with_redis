package com.example.dickkrt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping("/")
    public String b()
    {
        return "hello ";
    }

}


