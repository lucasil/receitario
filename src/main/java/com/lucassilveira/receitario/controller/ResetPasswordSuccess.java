package com.lucassilveira.receitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResetPasswordSuccess {

    @GetMapping("/reset-password-success")
    public String resetPswSuccess() {
        return "reset-password-success";
    }
}
