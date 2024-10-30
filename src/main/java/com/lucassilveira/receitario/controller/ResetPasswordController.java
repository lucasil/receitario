package com.lucassilveira.receitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResetPasswordController {

    @GetMapping("/reset-password")
    public String resetPsw(){
        return "reset-password";
    }
}
