package br.com.unimil.estilovip.domain.repository;

import br.com.unimil.estilovip.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByProdutoId(Long id);

    boolean existsByProdutoIdAndTamanho(Long id_produto, String tamanho);
}

