package com.lucassilveira.receitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
