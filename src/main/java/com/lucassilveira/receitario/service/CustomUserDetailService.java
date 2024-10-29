package com.lucassilveira.receitario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.repository.EmployeeRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        // Default role if none found
        String roleName = employee.getRole() != null ? employee.getRole().getName() : "USER";

        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .roles(roleName)
                .build();
    }
}
