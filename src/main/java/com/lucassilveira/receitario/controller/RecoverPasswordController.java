package com.lucassilveira.receitario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucassilveira.receitario.service.EmailService;

@Controller
public class RecoverPasswordController {

    @GetMapping("/recover")
    public String recover() {
        return "recover"; // Página de recuperação de senha
    }

    @Autowired
    private EmailService emailService;

    @GetMapping("/recover")
    public String processRecovery(@RequestParam String email) {
        // Lógica para envio de e-mail com link para redefinição de senha
        // Ex: enviarEmailParaRecuperacao(email)
        return "redirect:/recover?success";
    }



}
