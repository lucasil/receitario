package com.lucassilveira.receitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    private boolean validAuthentication(String username, String password) {
        // Lógica de autenticação
        return "usuario".equals(username) && "senha".equals(password);
    }

    @GetMapping("/login")
    public String showLogin(HttpServletRequest request, Model model) {
        // Verifica se há um cookie chamado "username" e se existir, adiciona seu valor ao modelo para que o campo seja preenchido automaticamente.
        // Verifica se há cookies e preenche o campo de usuário se houver
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    model.addAttribute("username", cookie.getValue());
                    break;
                } // fim if
            } // fim for
        } // fim if
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam(required = false) Boolean rememberMe,
                        Model model,
                        HttpServletResponse response) {
        // Método que lida com requisições POST para autenticar o usuário. Cria um cookue para lembrar o nome do usuário se o checkbox estiver marcado
        if (validAuthentication(username, password)) {
            // Se a checkbox estiver marcada, cria um cookie com o nome do usuário
            if (rememberMe != null && rememberMe) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60 * 60 * 24 * 30); // 30 dias
                cookie.getSecure(); // Cookie seguro
                cookie.setHttpOnly(true); // Impede acesso ao cookie via JavaScript
                response.addCookie(cookie);
            } // fim if
            // Redirecionar ou processar login bem sucedido
            return "redirect:/home";
        } // fim if
        else {
            // Remove o cookie em caso de falha de login
            Cookie cookie = new Cookie("username", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        
            // Falha de login    
            model.addAttribute("error", "Usuário ou senha inválidos.");
            return "login"; // Nome do arquivo HTML sem a extensão
        } // fim else
    }
}
