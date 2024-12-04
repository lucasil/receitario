package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.lucassilveira.receitario.model.DishCategory;
import com.lucassilveira.receitario.repository.DishCategoryRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DishCategoryController {

    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    // ADMINISTRADOR

    // Tela de apresentação de categorias de receitas
    @GetMapping("/admin/dish-categories")
    public String showDishCategoriesList(Model model) {
        // Obtém todos as categorias de pratos do banco de dados
        List<DishCategory> dishCategories = dishCategoryRepository.findAll();

        // Adiciona a lista de categorias de pratos ao modelo
        model.addAttribute("dishCategories", dishCategories);
        
        // Retorna o nome da página HTML (view) que vai exibir a lista de pratos ao modelo
        return "admin/dish-categories";
    }

    @PostMapping("/admin/dish-categories")
    public String mewDishCategory(@ModelAttribute @Valid DishCategory dishCategory,
                                BindingResult bindingResult) {
        // Se houver erros de validação, retorne para o formulário com os erros
        if (bindingResult.hasErrors()) {
            return "admin/dish-categories";
        }

        // Salva o novo usuário no banco de dados
        dishCategoryRepository.save(dishCategory);

        return "redirect:/admin/dish-categories?success"; // Redireciona com mensagem de sucesso
    }
}
