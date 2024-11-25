package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.EmployeeRepository;
import com.lucassilveira.receitario.repository.RoleRepository;
import com.lucassilveira.receitario.service.RoleService;

import jakarta.validation.Valid;

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

    // Tela de apresentação de usuários

    // Método para exibir a lista de usuários na página
    @GetMapping("/admin/users")
    public String showUsersList(Model model) {
        // Obtém todos os usuários e papeis do banco de dados
        List<Employee> employees = employeeRepository.findAll();
        List<Role> roles = roleService.getAllRoles();
        
        // Adiciona a lista de usuários e papeis ao modelo
        model.addAttribute("employees", employees);
        model.addAttribute("roles", roles);

        // Retorna o nome da página HTML (view) que vai exibir a lista de usuários
        return "admin/users";
    }

    @PostMapping("/admin/users")
    public String registerUser(@ModelAttribute @Valid Employee employee,
                                BindingResult bindingResult,
                                @RequestParam("role") int roleId) {
        // Se houver erros de validação, retorne para o formulário com os erros
        if (bindingResult.hasErrors()) {
            return "admin/users";
        }
        
        // Codifica a senha antes de salvar no banco
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));

        employee.setActive(true);

        // Define um papel padrão (exemplo: papel "USER")
        Role selectedRole = roleRepository.findById(roleId);

        if (selectedRole != null) {
            employee.setRole(selectedRole);
        } else {
            return "redirect:/admin/users?error";
        }

        // Salva o novo usuário no banco de dados
        employeeRepository.save(employee);

        return "redirect:/admin/users?success"; // Redireciona com mensagem de sucesso
    }

    @PostMapping("/admin/deactivate")
    public String deactivateUser(@RequestParam("id") int id, 
                                    Model model) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setActive(false); // Desativa o usuário
            employeeRepository.save(employee); // Salva a alteração
        }

        model.addAttribute("employees", employeeRepository.findAll());
        
        return "admin/users";
    } 
}
