package com.lucassilveira.receitario.seeder;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.EmployeeRepository;
import com.lucassilveira.receitario.repository.RoleRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String...args) throws Exception {
        // Criar Roles
        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setName("Administrador");
        roleRepository.save(adminRole);

        Role chefRole = new Role();
        chefRole.setId(2);
        chefRole.setName("Cozinheiro");
        roleRepository.save(chefRole);

        Role tasterRole = new Role();
        tasterRole.setId(3);
        tasterRole.setName("Degustador");
        roleRepository.save(tasterRole);

        Role editorRole = new Role();
        editorRole.setId(4);
        editorRole.setName("Editor");
        roleRepository.save(editorRole);

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
