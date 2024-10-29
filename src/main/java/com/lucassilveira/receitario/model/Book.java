package com.lucassilveira.receitario.model;

import java.util.List;

import io.micrometer.common.lang.Nullable;
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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class Book {

    // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Insira um título para o livro")
    @Column(name = "title")
    private String title;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "isbn", 
            unique = true)
    private String isbn;

    // Relationship

    @ManyToOne(fetch = FetchType.EAGER, 
                optional = true)
    @JoinColumn(name = "editor_id", 
                nullable = true)
    private Employee editorEmployee;

    @OneToMany(mappedBy = "book", 
                fetch = FetchType.LAZY)
    private List<Publication> publications;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Employee getEditorEmployee() {
        return editorEmployee;
    }

    public void setEditorEmployee(Employee editorEmployee) {
        this.editorEmployee = editorEmployee;
    }
    
    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

} // Book Entity
