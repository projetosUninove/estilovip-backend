package br.com.unimil.estilovip.domain.dto;

public record ItemDto(
        String tamanho,
        Integer quantidade,
        Long idProduto
) {
}
