package com.oldou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowTagsController {
    @GetMapping("/tags")
    public String tags(){
        return "tags";
    }

}
