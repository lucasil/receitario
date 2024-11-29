package com.lucassilveira.receitario.seeder;

import java.math.BigDecimal;
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
        Role chefRole = roleRepository.findById(2);
        Role tasterRole = roleRepository.findById(3);
        Role editorRole = roleRepository.findById(4);

        if (adminRole == null) {
            throw new IllegalStateException("Atribuição 'Administrador' não encontrada.");
        }

        // Criar usuários
        Employee adminEmployee = new Employee();
        adminEmployee.setId(1); // ID do administrador
        adminEmployee.setName("Lucas Silveira");
        adminEmployee.setTradeName(null);
        adminEmployee.setRg("1234567");
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

        Employee chefEmployee = new Employee();
        chefEmployee.setId(2); // ID do cozinheiro
        chefEmployee.setName("Marcela Lopes");
        chefEmployee.setTradeName("Ml Drinks");
        chefEmployee.setRg("2345678");
        chefEmployee.setBirthDate(LocalDate.of(2001, 2, 2));
        chefEmployee.setSalary(BigDecimal.valueOf(1500));
        chefEmployee.setAdmissionDate(LocalDate.now());
        chefEmployee.setEndDate(null);
        chefEmployee.setUsername("mld123");
        chefEmployee.setPassword(passwordEncoder.encode("234567"));
        chefEmployee.setEmail("email@gmail.com");
        chefEmployee.setActive(true);
        chefEmployee.setRole(chefRole);
        employeeRepository.save(chefEmployee);
        
        Employee tasterEmployee = new Employee();
        tasterEmployee.setId(3); // ID do cozinheiro
        tasterEmployee.setName("José Maria");
        tasterEmployee.setTradeName(null);
        tasterEmployee.setRg("3456789");
        tasterEmployee.setBirthDate(LocalDate.of(2002, 3, 3));
        tasterEmployee.setSalary(BigDecimal.valueOf(2500));
        tasterEmployee.setAdmissionDate(LocalDate.now());
        tasterEmployee.setEndDate(null);
        tasterEmployee.setUsername("joseM");
        tasterEmployee.setPassword(passwordEncoder.encode("345678"));
        tasterEmployee.setEmail("email1@gmail.com");
        tasterEmployee.setActive(true);
        tasterEmployee.setRole(tasterRole);
        employeeRepository.save(tasterEmployee);
        
        Employee editorEmployee = new Employee();
        editorEmployee.setId(4); // ID do cozinheiro
        editorEmployee.setName("Maria José");
        editorEmployee.setTradeName("Editora Maria Receitas");
        editorEmployee.setRg("4567890");
        editorEmployee.setBirthDate(LocalDate.of(2003, 4, 4));
        editorEmployee.setSalary(BigDecimal.valueOf(5000));
        editorEmployee.setAdmissionDate(LocalDate.now());
        editorEmployee.setEndDate(null);
        editorEmployee.setUsername("MJ123");
        editorEmployee.setPassword(passwordEncoder.encode("456789"));
        editorEmployee.setEmail("email3@gmail.com");
        editorEmployee.setActive(true);
        editorEmployee.setRole(editorRole);
        employeeRepository.save(editorEmployee);
    }
}
