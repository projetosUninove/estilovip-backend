package br.com.unimil.estilovip.controller;

import br.com.unimil.estilovip.domain.dto.ItemDto;
import br.com.unimil.estilovip.domain.dto.QuantidadeDto;
import br.com.unimil.estilovip.domain.model.Item;
import br.com.unimil.estilovip.domain.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Retorna todos os itens cadastrados")
    public ResponseEntity<List<Item>> buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna item por id")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @GetMapping("/produtos/{id}")
    @Operation(summary = "Retorna item por id de um produto")
    public ResponseEntity<List<Item>> buscarPorIdProduto(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorIdProduto(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo item")
    public ResponseEntity<Item> cadastrar(@RequestBody ItemDto dto, UriComponentsBuilder uriBuilder) {
        Item resposta = service.cadastrar(dto);
        URI uri = uriBuilder.path("/itens/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Adiciona a quantidade de itens")
    public ResponseEntity<Item> adicionar(@PathVariable Long id, @RequestBody QuantidadeDto dto) {
        return ResponseEntity.ok().body(service.adicionar(id, dto.quantidade()));
    }

    @PutMapping("/remover/{id}")
    @Operation(summary = "Subtrai a quantidade de itens")
    public ResponseEntity<Item> remover(@PathVariable Long id, @RequestBody QuantidadeDto dto) {
        return ResponseEntity.ok().body(service.remover(id, dto.quantidade()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um item por id")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}