package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {

    @Autowired
    private RoleRepository roleRepository;

    // ADMINISTRADOR

    // Tela de apresentação de atribuições
    @GetMapping("/admin/roles")
    public String showRolesList(Model model) {
        // Obtém todos os usuários do banco de dados
        List<Role> roles = roleRepository.findAll();

        // Adiciona a lista de atribioções ao modelo
        model.addAttribute("roles", roles);
        
        // Retorna o nome da página HTML (view) que vai exibir a lista de atribuições
        return "admin/roles";
    }
}
