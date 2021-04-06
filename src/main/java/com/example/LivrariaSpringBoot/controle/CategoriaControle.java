package com.example.LivrariaSpringBoot.controle;

import com.example.LivrariaSpringBoot.dto.CategoriaDto;
import com.example.LivrariaSpringBoot.modelo.Categoria;
import com.example.LivrariaSpringBoot.servico.CategoriaServico;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
public class CategoriaControle {

    @Autowired
    private CategoriaServico categoriaServico;

    
    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {

        Categoria obj = categoriaServico.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    
    
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {

        List<Categoria> list = categoriaServico.findAll();
        List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);

    }

    
    
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {

        categoria = categoriaServico.create(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    
    
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @RequestBody CategoriaDto categoria) {

        Categoria ob = categoriaServico.update(id, categoria);

        return ResponseEntity.ok().body(new CategoriaDto(ob));
    }

    
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        categoriaServico.delete(id);

        return ResponseEntity.noContent().build();

    }
    
    

}
