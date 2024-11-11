package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.EmployeeRepository;
import com.lucassilveira.receitario.repository.RoleRepository;
import com.lucassilveira.receitario.service.RoleService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // ADMINISTRADOR

    @Autowired
    private RoleService roleService;

    // Exibe o formulário de cadastro de usuário
    @GetMapping("/admin/register")
    public String showRegistrationForm(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("employee", new Employee());
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String registerUser(Employee employee) {
        // Codifica a senha antes de salvar no banco
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));

        // Define um papel padrão (exemplo: papel "USER")
        Role selectedRole = roleRepository.findByName("Administrador");
        employee.setRole(selectedRole);

        // Salva o novo usuário no banco de dados
        employeeRepository.save(employee);

        return "redirect:/admin/register?success"; // Redireciona com mensagem de sucesso
    }

}
