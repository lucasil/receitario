package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.lucassilveira.receitario.model.Measure;
import com.lucassilveira.receitario.repository.MeasureRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MeasureController {

    @Autowired
    private MeasureRepository measureRepository;

    // ADMINISTRADOR

    // Tela de apresentação de medidas
    @GetMapping("/admin/measures")
    public String showMeasuresList(Model model) {
        // Obtém todos os ingredientes do banco de dados
        List<Measure> measures = measureRepository.findAll();

        // Adiciona a lista de ingredientes ao modelo
        model.addAttribute("measures", measures);
        
        // Retorna o nome da página HTML (view) que vai exibir a lista de medidas ao modelo
        return "admin/measures";
    }

    @PostMapping("/admin/measures")
    public String mewMeasure(@ModelAttribute @Valid Measure measure,
                                BindingResult bindingResult) {
        // Se houver erros de validação, retorne para o formulário com os erros
        if (bindingResult.hasErrors()) {
            return "admin/measures";
        }

        // Salva o novo usuário no banco de dados
        measureRepository.save(measure);

        return "redirect:/admin/measures?success"; // Redireciona com mensagem de sucesso
    }
}
