package com.lucassilveira.receitario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucassilveira.receitario.service.UserService;

@Controller
public class ResetPasswordController {

    @Autowired
    private UserService userService;

    @GetMapping("/reset-password")
    public String showResetForm(@RequestParam String token, Model model) {
        model.addAttribute("token", token); // Passa o token para a view
        return "reset-password"; // Nome do arquivo HTML sem a extensão
    }

    @PostMapping("/reset-password")
    public String resetPsw(@RequestParam String new_password,
                            @RequestParam String new_password_conf,
                            @RequestParam String token,
                            Model model){
        // Verifica se as senhas são iguais
        if (!new_password.equals(new_password_conf)) {
            model.addAttribute("error", "As senhas não correspondem.");
            model.addAttribute("token", token);
            return "reset-password";
        } // fim if

        boolean success = userService.updatePsw(token, new_password);

        if (success) {
            model.addAttribute("success", "Senha alterada com sucesso!");
            return "login";
        } // fim if 
        else {
            model.addAttribute("error", "Ocorreu um erro ao redefinir a senha. Verifique o token.");
            model.addAttribute("token", token);
            return "reset-password";
        } // fim else
    }
}
