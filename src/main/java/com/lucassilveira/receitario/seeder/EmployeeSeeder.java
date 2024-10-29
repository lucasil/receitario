package com.lucassilveira.receitario.seeder;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.EmployeeRepository;
import com.lucassilveira.receitario.repository.RoleRepository;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class EmployeeSeeder implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String...args) throws Exception {
        // Recuperar a role do administrador
        Role adminRole = roleRepository.findById(1);

        if (adminRole == null) {
            throw new IllegalStateException("Atribuição 'Administrador' não encontrada.");
        }

        // Criar o usuário administrador
        Employee adminEmployee = new Employee();
        adminEmployee.setId(1); // ID do administrador
        adminEmployee.setName("Lucas Silveira");
        adminEmployee.setTradeName(null);
        adminEmployee.setRg("12.345.678-9");
        adminEmployee.setBirthDate(LocalDate.of(2000, 1, 1));
        adminEmployee.setSalary(null);
        adminEmployee.setAdmissionDate(LocalDate.now());
        adminEmployee.setEndDate(null);
        adminEmployee.setUsername("lucasil");
        adminEmployee.setPassword(passwordEncoder.encode("123456"));
        adminEmployee.setEmail("lucas07.macedo@gmail.com");
        adminEmployee.setActive(true);
        adminEmployee.setRole(adminRole);

        employeeRepository.save(adminEmployee);
    }
}
