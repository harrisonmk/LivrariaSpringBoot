package com.example.LivrariaSpringBoot.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @NotEmpty(message = "Campo Titulo eh obrigatorio") //Nao pode ser vazio
    @Length(min =3, max = 50,message = "O campo Descricao deve ter entre 3 e 50 caracteres") //min 3 caracteres e maximo 50 caracteres
    private String titulo;
    
    
    @NotEmpty(message = "Campo NomeAutor eh obrigatorio") //Nao pode ser vazio
    @Length(min =3, max = 100,message = "O campo NomeAutor deve ter entre 3 e 100 caracteres") //min 3 caracteres e maximo 100 caracteres
    private String nomeAutor;
    
    
    @NotEmpty(message = "Campo Texto eh obrigatorio") //Nao pode ser vazio
    @Length(min =10, max = 200000,message = "O campo Texto deve ter entre 10 e 200000 caracteres") //min 10 caracteres e maximo 200000 caracteres
    private String texto;
    
    @JsonIgnore //ignora as categorias do livro
    @ManyToOne //um livro possui uma categoria
    @JoinColumn(name= "categoria_id")
    private Categoria categoria;

    
    
    public Livro(Long id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    
    
    public Livro() {
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}
