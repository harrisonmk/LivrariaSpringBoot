package com.example.LivrariaSpringBoot.servico;

import com.example.LivrariaSpringBoot.dto.CategoriaDto;
import com.example.LivrariaSpringBoot.excecoes.DataIntegrityViolationException;
import com.example.LivrariaSpringBoot.excecoes.ObjectNotFoundException;
import com.example.LivrariaSpringBoot.modelo.Categoria;
import com.example.LivrariaSpringBoot.repositorio.CategoriaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    
    
    public Categoria findById(Long id) {

        Optional<Categoria> obj = categoriaRepositorio.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));

    }

    
    
    public List<Categoria> findAll() {

        return categoriaRepositorio.findAll();

    }

    
    
    public Categoria create(Categoria categoria) {

        categoria.setId(null);
        return categoriaRepositorio.save(categoria);

    }

    
    
    public Categoria update(Long id, CategoriaDto categoriaDto) {

        Categoria obj = findById(id);

        obj.setNome(categoriaDto.getNome());
        obj.setDescricao(categoriaDto.getDescricao());

        return categoriaRepositorio.save(obj);

    }

    
    
    public void delete(Long id) {

        this.findById(id);
        try {
            categoriaRepositorio.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityViolationException("Categoria nao pode ser deletado! Possui livros associados");

        }

    }
    
    

}
