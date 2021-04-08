package com.example.LivrariaSpringBoot.dto;

import com.example.LivrariaSpringBoot.modelo.Categoria;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    
    @NotEmpty(message = "Campo Nome eh obrigatorio") //Nao pode ser vazio
    @Length(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres") //min 3 caracteres e maximo 100 caracteres
    private String nome;

    @NotEmpty(message = "Campo Descricao eh obrigatorio") //Nao pode ser vazio
    @Length(min = 3, max = 200, message = "O campo Descricao deve ter entre 3 e 200 caracteres") //min 3 caracteres e maximo 200 caracteres
    private String descricao;

    
    
    public CategoriaDto(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public CategoriaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    

}
