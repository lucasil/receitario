package com.lucassilveira.receitario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lucassilveira.receitario.model.Measure;
import com.lucassilveira.receitario.repository.MeasureRepository;
import org.springframework.web.bind.annotation.GetMapping;

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
}
