package com.lucassilveira.receitario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.repository.EmployeeRepository;

@Service
public class ChefService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getLoggedInChef(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
        
            return employeeRepository.findByUsername(username);
        }
        
        throw new RuntimeException("Usuário não autenticado ou principal inválido");
    }
}
