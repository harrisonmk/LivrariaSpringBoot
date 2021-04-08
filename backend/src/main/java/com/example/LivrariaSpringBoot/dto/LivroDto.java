package com.example.LivrariaSpringBoot.dto;

import com.example.LivrariaSpringBoot.modelo.Livro;
import java.io.Serializable;

public class LivroDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    private Long id;
    private String titulo;

    
    public LivroDto(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
    
    
    
    public LivroDto() {
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    

}
