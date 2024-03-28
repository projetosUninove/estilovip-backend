package br.com.unimil.estilovip.domain.model;

import br.com.unimil.estilovip.domain.dto.ItemDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @JsonIgnoreProperties("item")
    private Produto produto;

    public Item(ItemDto dto, Produto produto) {
        this.tamanho = dto.tamanho();
        this.quantidade = dto.quantidade();
        this.produto = produto;
    }

    public Item adicionar(Integer quantidade) {
        this.quantidade += quantidade;
        return this;
    }

    public Item remover(Integer quantidadeRemover) {
        this.quantidade -= quantidadeRemover;
        return this;
    }
}