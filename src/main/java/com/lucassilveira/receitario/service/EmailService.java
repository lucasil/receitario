package com.lucassilveira.receitario.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendPasswordResetEmail(String to, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Equipe Receitário");
        message.setTo(to);
        message.setSubject("Redefinição de Senha");
        message.setText("Clique no link para redefinir rua senha: " 
                    + "http://localhost:8080/reset-password?token=" 
                    + token);
        mailSender.send(message);
    }

}
