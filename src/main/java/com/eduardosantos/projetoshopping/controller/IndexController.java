package com.eduardosantos.projetoshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @GetMapping(value = "")
    public String indexPage(){
        return "index";
    }
}
