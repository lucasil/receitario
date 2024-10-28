package com.lucassilveira.receitario.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira um nome de usuário")
    @Size(min = 3,
            max = 50,
            message = "O nome de usuário deve ter entre 3 e 50 caracteres")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Insira uma senha")
    @Size(min = 3,
            max = 50,
            message = "A senha deve ter entre 3 e 50 caracteres")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Insira um e-mail válido")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "active")
    private Boolean active;

    // Relationship 
    
    // -- Relacionamento com a entidade Employee

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

} // Role Entity
