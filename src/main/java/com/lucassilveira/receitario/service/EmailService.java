package com.lucassilveira.receitario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendResetEmail(String email, String token) {
        String link = "http://localhost:8080/reset-password?token=" + token;
        String subject = "Redefinição de Senha";
        String message = "Clique no link a seguir para redefinir sua senha: " + link;

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(message, true);
            mailSender.send(mimeMessage);
        } // fim try 
        catch (MessagingException e) {
            // Log do erro
            System.err.println("Erro ao enviar e-mail: " + e.getMessage());
            // Retorna um valor ou lança uma exceção para indicar a falha no envio do e-mail
            throw new RuntimeException("Erro ao enviar e-mail de redefinição de senha.");
        } // fim catch
    }
}