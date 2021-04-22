
package com.example.LivrariaSpringBoot.repositorio;

import com.example.LivrariaSpringBoot.modelo.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
    
    //Ordena a lista de categorias por nome
    @Query("SELECT obj FROM Categoria obj ORDER BY obj.nome")
    public List<Categoria> findAll();
    
}
