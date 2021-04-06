
package com.example.LivrariaSpringBoot.repositorio;

import com.example.LivrariaSpringBoot.modelo.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro,Long> {

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    public List<Livro> findAllByCategoria(@Param(value = "id_cat") Long id_cat);
    
}
