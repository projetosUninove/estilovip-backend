package br.com.unimil.estilovip.domain.dto;

import br.com.unimil.estilovip.domain.model.Endereco;
import br.com.unimil.estilovip.domain.model.Usuario;

public record UsuarioDto(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String email,
        Endereco endereco
) {

    public UsuarioDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getEndereco()
        );
    }
}
