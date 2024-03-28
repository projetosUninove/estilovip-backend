package br.com.unimil.estilovip.controller;

import br.com.unimil.estilovip.domain.model.Produto;
import br.com.unimil.estilovip.domain.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Retorna todos os produtos")
    public ResponseEntity<Page<Produto>> buscarTodos(Pageable page) {
        return ResponseEntity.ok().body(service.buscarTodos(page));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna produto por id")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo produto")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto, UriComponentsBuilder uriBuilder) {
        Produto resposta = service.criar(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um produto por id")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
