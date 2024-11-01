package com.lucassilveira.receitario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucassilveira.receitario.service.UserService;

@Controller
public class RecoverPasswordController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/recover")
    public String showRecover() {
        return "recover"; // Página de recuperação de senha
    }

    @PostMapping("/recover")
    public String processRecovery(@RequestParam String email, Model model){
        userService.sendResetToken(email);
        model.addAttribute("success", "Um link de redefinição foi enviado para seu e-mail.");
        return "recover";
    }
}
