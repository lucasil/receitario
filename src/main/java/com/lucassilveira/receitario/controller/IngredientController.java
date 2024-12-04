package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.lucassilveira.receitario.model.Ingredient;
import com.lucassilveira.receitario.repository.IngredientRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    // ADMINISTRADOR

    // Tela de apresentação de ingrediente
    @GetMapping("/admin/ingredients")
    public String showIngredientsList(Model model) {
        // Obtém todos os ingredientes do banco de dados
        List<Ingredient> ingredients = ingredientRepository.findAll();

        // Adiciona a lista de ingredientes ao modelo
        model.addAttribute("ingredients", ingredients);
        
        // Retorna o nome da página HTML (view) que vai exibir a lista de ingredientes ao modelo
        return "admin/ingredients";
    }
    
    @PostMapping("/admin/ingredients")
    public String mewIngredient(@ModelAttribute @Valid Ingredient ingredient,
                                BindingResult bindingResult) {
        // Se houver erros de validação, retorne para o formulário com os erros
        if (bindingResult.hasErrors()) {
            return "admin/ingredients";
        }

        // Salva o novo usuário no banco de dados
        ingredientRepository.save(ingredient);

        return "redirect:/admin/ingredients?success"; // Redireciona com mensagem de sucesso
    }

}
