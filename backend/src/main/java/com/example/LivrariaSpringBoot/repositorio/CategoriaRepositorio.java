
package com.example.LivrariaSpringBoot.repositorio;

import com.example.LivrariaSpringBoot.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
    
}
