package com.lucassilveira.receitario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.repository.EmployeeRepository;

@Service
public class UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean isValidToken(String token) {
        // Verifica se o token existe e se é válido
        Employee employee = employeeRepository.findByResetToken(token);
        return employee != null;
    }

    // Redefine a senha usando o token
    public boolean updatePsw(String token, String newPsw) {
        Employee employee = employeeRepository.findByResetToken(token);
        if (employee != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // criptografa a nova senha
            employee.setPassword(encoder.encode(newPsw));
            employee.setResetToken(null);
            employeeRepository.save(employee); // salva as alterações
            System.out.println("Senha redefinida com sucesso para o usuário: " + employee.getUsername());
            return true;
        } // fim if
        else {
            System.out.println("Token inválido ou expirado.");
        } // fim else
        return false;
    }
}
