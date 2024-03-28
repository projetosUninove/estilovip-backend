package br.com.unimil.estilovip.domain.dto;

import br.com.unimil.estilovip.domain.model.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioRequisicaoDto(
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        @CPF
        String cpf,
        @NotBlank
        String email,
        @NotBlank
        String senha,
        @NotNull
        Endereco endereco
) {
}
