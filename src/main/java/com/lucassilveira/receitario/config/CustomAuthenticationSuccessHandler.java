package com.lucassilveira.receitario.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    // Responsável por redirecionar o usuário para a página específica de acordo com o role

    public void onAuthenticationSuccess(HttpServletRequest request, 
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Administrador"))) {
            response.sendRedirect("/admin/index");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Cozinheiro"))) {
            response.sendRedirect("/chef/index");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Degustador"))) {
            response.sendRedirect("/taster/index");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Editor"))) {
            response.sendRedirect("editor/index");
        } else {
            response.sendRedirect("/default/index");
        }
    }
}
