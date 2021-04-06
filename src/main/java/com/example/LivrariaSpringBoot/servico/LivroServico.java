package com.example.LivrariaSpringBoot.servico;

import com.example.LivrariaSpringBoot.excecoes.ObjectNotFoundException;
import com.example.LivrariaSpringBoot.modelo.Categoria;
import com.example.LivrariaSpringBoot.modelo.Livro;
import com.example.LivrariaSpringBoot.repositorio.LivroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServico {
    
    @Autowired
    private LivroRepositorio livroRepositorio;
    
    @Autowired
    private CategoriaServico categoriaServico;
    
    
    
    
    public Livro findById(Long id) {
        
        Optional<Livro> obj = livroRepositorio.findById(id);
        
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
        
    }
    
    
    
    public List<Livro> findAll(Long id) {
        
        categoriaServico.findById(id);
        
        return livroRepositorio.findAllByCategoria(id);
        
    }
    
    
    
    public Livro update(Long id, Livro livro) {
        
        Livro newLivro = findById(id);
        updateData(newLivro, livro);
        
        return livroRepositorio.save(newLivro);
        
    }
    
    
    
    private void updateData(Livro newLivro, Livro livro) {
        
        newLivro.setTitulo(livro.getTitulo());
        newLivro.setNomeAutor(livro.getNomeAutor());
        newLivro.setTexto(livro.getTexto());
        
    }
    
    
    
    public Livro create(Long id, Livro livro) {
        
        livro.setId(null);
        Categoria cat = categoriaServico.findById(id);
        livro.setCategoria(cat);
        
        return livroRepositorio.save(livro);
    }
    
    
    
    
    public void delete(Long id) {
        
        Livro livro = this.findById(id);
        livroRepositorio.delete(livro);
        
    }
    
    
    
    
    
}
