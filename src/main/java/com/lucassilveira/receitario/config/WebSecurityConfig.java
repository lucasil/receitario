package com.lucassilveira.receitario.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.lucassilveira.receitario.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/recover", "/reset-password", "/reset-password-success", "css/**", "/js/**").permitAll() // Permitir acesso sem autenticação
                .requestMatchers("/admin/**"). hasRole("Administrador")
                .requestMatchers("/chef/**"). hasRole("Cozinheiro")
                .requestMatchers("/taster/**"). hasRole("Degustador")
                .requestMatchers("/editor/**"). hasRole("Editor")
                .anyRequest().authenticated() // Qualquer outra requisição precisa de autenticação
            )   
            .formLogin((form) -> form
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/home", true) // Redirecionar à página home após login
                .permitAll() // Permitir acesso à página de login
            )
            .logout((logout) -> logout
                .permitAll() // Permitir logout
            )
            .rememberMe(rememberMe -> rememberMe
                .userDetailsService(customUserDetailService) // Usar o CustomUserDetailsService
                .key("uniqueAndSecret") // Chave para criptografar o cookie
                .tokenValiditySeconds(86400) // Tempo de validade do cookie - ex: 1 dia
            );

        return http.build(); // Retorna a configuração de segurança

    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para criptografar senhas
    }

}
