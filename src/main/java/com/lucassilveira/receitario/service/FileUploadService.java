package com.lucassilveira.receitario.service;

import org.springframework.beans.factory.annotation.Value;

public class FileUploadService {
    
    @Value("${file.upload-dir}")
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }
}
