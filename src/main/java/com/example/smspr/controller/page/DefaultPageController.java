package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultPageController {

    //24-07-09
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/index2")
    public String dddd(){
        return "index2";
    }
    @GetMapping({"/home","/home2"})
    public String home(){
        return "index";
    }

    //24-07-10
    @GetMapping("/")
    public String empty(){
        return "index";
    }
    @GetMapping({"","/index"})
    public String empty1(){
        return "redirect:/";
    }
    @GetMapping("/page1")
    public String page1(){
        return "page1";
    }
}
