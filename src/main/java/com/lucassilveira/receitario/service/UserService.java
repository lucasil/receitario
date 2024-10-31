package com.lucassilveira.receitario.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.repository.EmployeeRepository;

@Service
public class UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    // Gera e envia o token de redefinição
    public void sendResetToken(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            String token = UUID.randomUUID().toString();
            employee.setResetToken(token);
            employeeRepository.save(employee);
            emailService.sendResetEmail(employee.getEmail(), token);
        } // fim if
    }

    // Redefine a senha usando o token
    public boolean updatePsw(String token, String newPsw) {
        Employee employee = employeeRepository.findByResetToken(token);
        if (employee != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // criptografa a nova senha
            employee.setPassword(encoder.encode(newPsw));
            employee.setResetToken(null);
            employeeRepository.save(employee); // salva as alterações
            return true;
        } // fim if
        return false;
    }
}
