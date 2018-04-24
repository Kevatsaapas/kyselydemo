package com.kevatsaapas.kyselydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/etusivu")
    public String etusivu(){
        return "etusivu";
    }

    @RequestMapping("/uusikysely")
    public String uusikysely(){
        return "uusikysely";
    }
}
