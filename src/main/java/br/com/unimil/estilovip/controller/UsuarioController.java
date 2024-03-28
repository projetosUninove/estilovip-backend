package br.com.unimil.estilovip.controller;

import br.com.unimil.estilovip.domain.dto.UsuarioDto;
import br.com.unimil.estilovip.domain.dto.UsuarioRequisicaoDto;
import br.com.unimil.estilovip.domain.model.Usuario;
import br.com.unimil.estilovip.domain.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Retorna todos os usuários")
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna usuário por id")
    public ResponseEntity<UsuarioDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscar(id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuário")
    public ResponseEntity<UsuarioDto> criar(@RequestBody UsuarioRequisicaoDto dto, UriComponentsBuilder uriBuilder) {
        UsuarioDto resposta = service.criar(dto);
        URI uri = uriBuilder.path("/usarios/{id}").buildAndExpand(resposta.id()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um usuário por id")
    public ResponseEntity deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}