package com.xunmaw.car.maintain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @RequestMapping(value = "/")
    public String index(){
        System.out.println("/index");
        return "login";
    }
}