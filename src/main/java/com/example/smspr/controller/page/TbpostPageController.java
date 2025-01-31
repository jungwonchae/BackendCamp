package com.example.smspr.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbpost")
@Controller
public class TbpostPageController {

    //24-07-10
    @GetMapping("/{page}")
    public String page(@PathVariable("page") String page){
        return "tbpost/" + page;
    }

    //2024-07-11
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id){
        return "tbpost/detail";
    }
}
