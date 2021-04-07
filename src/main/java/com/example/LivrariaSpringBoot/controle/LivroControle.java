package com.example.LivrariaSpringBoot.controle;

import com.example.LivrariaSpringBoot.dto.LivroDto;
import com.example.LivrariaSpringBoot.modelo.Livro;
import com.example.LivrariaSpringBoot.servico.LivroServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Tag( name = "Api Rest Livro")
@RestController
@RequestMapping("/livros")
public class LivroControle {

    @Autowired
    private LivroServico livroService;

    
    @Operation(summary="Retorna um unico livro") 
    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {

        Livro obj = livroService.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    
    @Operation(summary="Retorna uma lista de livros") 
    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "/categoria", defaultValue = "0") Long id_cat) {

        List<Livro> list = livroService.findAll(id_cat);
        List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    
    @Operation(summary="Edita um livro") 
    @PutMapping("/{id}") //atualiza o objeto inteiro
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {

        Livro newLivro = livroService.update(id, livro);

        return ResponseEntity.ok().body(newLivro);

    }

    
    @Operation(summary="Edita um ou mais atributos de um livro") 
    @PatchMapping("/{id}") //pode atualizar apenas um campo do objeto
    public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro livro) {

        Livro newLivro = livroService.update(id, livro);

        return ResponseEntity.ok().body(newLivro);

    }

    
    @Operation(summary="Salva um livro") 
    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat, @RequestBody Livro livro) {

        Livro newLivro = livroService.create(id_cat, livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newLivro.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    
    
    @Operation(summary="Deleta um livro") 
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        livroService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
    

}
