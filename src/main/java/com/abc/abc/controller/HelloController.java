package com.abc.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/view")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("ajax")
    @ResponseBody
    String ajax() {
        return "login success!!!";
    }
}
