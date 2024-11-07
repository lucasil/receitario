package com.lucassilveira.receitario.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        // Extrai o nome do papel do Employee e cria a autoridade
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + employee.getRole().getName());
        
        return org.springframework.security.core.userdetails.User.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .authorities(Collections.singleton(authority)) // Passa o papel único como autoridade
                .build();
    }
}
