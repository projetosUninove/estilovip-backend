package br.com.unimil.estilovip.domain.service;

import br.com.unimil.estilovip.domain.dto.UsuarioDto;
import br.com.unimil.estilovip.domain.dto.UsuarioRequisicaoDto;
import br.com.unimil.estilovip.domain.exception.UsuarioNaoEncontradoException;
import br.com.unimil.estilovip.domain.model.Usuario;
import br.com.unimil.estilovip.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public UsuarioDto buscar(Long id) {
        return new UsuarioDto(buscarPorId(id));
    }

    public UsuarioDto criar(UsuarioRequisicaoDto dto) {
        Usuario usuario = repository.save(new Usuario(dto));
        return new UsuarioDto(usuario);
    }

    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id);
        repository.delete(usuario);
    }

    private Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
    }

}
