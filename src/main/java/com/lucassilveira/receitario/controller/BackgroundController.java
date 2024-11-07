package com.lucassilveira.receitario.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackgroundController {

    @Value("${app.backgrounds.path:/images/}")
    private String backgroundsPath;

    @GetMapping("/api/images")
    public  List<String> getBackgroundImages() {
        return Arrays.asList(
            backgroundsPath + "background1.jpg",
            backgroundsPath + "background2.jpg",
            backgroundsPath + "background3.jpg",
            backgroundsPath + "background4.jpg",
            backgroundsPath + "background5.jpg",
            backgroundsPath + "background6.jpg"  
        );
    }
}
