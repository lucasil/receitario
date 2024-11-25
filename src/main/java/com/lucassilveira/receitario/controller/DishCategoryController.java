package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lucassilveira.receitario.model.DishCategory;
import com.lucassilveira.receitario.repository.DishCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;

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
}
