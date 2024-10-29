package com.lucassilveira.receitario.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.RoleRepository;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String...args) throws Exception {
        // Criar Roles
        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setName("Administrador");
        adminRole.setDescription("Responsável pela gestão do sistema, incluindo ingredientes, categorias, papéis de usuários e monitoramento das receitas postadas mensalmente.");
        roleRepository.save(adminRole);

        Role chefRole = new Role();
        chefRole.setId(2);
        chefRole.setName("Cozinheiro");
        chefRole.setDescription("Insere e cria novas receitas no sistema, garantindo que sejam claras e detalhadas.");
        roleRepository.save(chefRole);

        Role tasterRole = new Role();
        tasterRole.setId(3);
        tasterRole.setName("Degustador");
        tasterRole.setDescription("Avalia e fornece feedback sobre as receitas, ajudando a destacar as melhores opções disponíveis.");
        roleRepository.save(tasterRole);

        Role editorRole = new Role();
        editorRole.setId(4);
        editorRole.setName("Editor");
        editorRole.setDescription("Seleciona receitas para publicação e organiza livros de receitas, promovendo coleções temáticas para os usuários.");
        roleRepository.save(editorRole);
    }
}
