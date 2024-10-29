package com.lucassilveira.receitario.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @NotBlank(message = "Insira o nome do funcionário")
    @Size(min = 3,
            max = 100,
            message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(name = "name")
    private String name;

    @Nullable
    @Size(min = 3,
            max = 100,
            message = "O nome fantasia deve ter entre 3 e 100 caracteres")
    @Column(name = "trade_name")
    private String tradeName;
    
    @NotBlank(message = "Insira um RG válido")
    @Pattern(regexp = "^\\d{1,2}\\.?\\d{3}\\.?\\d{3}-?\\d{1}$", 
                message = "Insira um RG válido. Ex: 12.345.678-9 ou 123456789")
    @Column(name = "rg", unique = true)
    private String rg;

    @Nullable
    @Past(message = "A data de nascimento deve ser no passado")
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Nullable
    @PositiveOrZero(message = "Insira um salário válido")
    @Digits(integer = 6, 
            fraction = 2, 
            message = "O salário deve ter no máximo 6 dígitos inteiros e 2 decimais")
    @Column(name = "salary")
    private BigDecimal salary;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "adm_date")
    private LocalDate admissionDate;

    @Nullable
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private LocalDate endDate;

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

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                optional = true)
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

    @OneToMany(mappedBy = "employee",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<WorkingReference> workingReferences;

    @OneToMany(mappedBy = "tasterEmployee",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<TastingSession> tastingSessions;

    @OneToMany(mappedBy = "chefEmployee",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    @OneToMany(mappedBy = "editorEmployee",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<Book> books;


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<WorkingReference> getWorkingReferences() {
        return workingReferences;
    }

    public void setWorkingReferences(List<WorkingReference> workingReferences) {
        this.workingReferences = workingReferences;
    }

    public List<TastingSession> getTastingSessions() {
        return tastingSessions;
    }

    public void setTastingSessions(List<TastingSession> tastingSessions) {
        this.tastingSessions = tastingSessions;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

} // Employee Entity
