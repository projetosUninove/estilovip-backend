package br.com.unimil.estilovip.domain.service;

import br.com.unimil.estilovip.domain.dto.ItemDto;
import br.com.unimil.estilovip.domain.exception.ItemJaCadastradoException;
import br.com.unimil.estilovip.domain.exception.ItemNaoEncontradoException;
import br.com.unimil.estilovip.domain.exception.QuantidadeInsuficienteException;
import br.com.unimil.estilovip.domain.model.Item;
import br.com.unimil.estilovip.domain.model.Produto;
import br.com.unimil.estilovip.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;
    private final ProdutoService produtoService;

    @Autowired
    public ItemService(ItemRepository repository, ProdutoService produtoService) {
        this.repository = repository;
        this.produtoService = produtoService;
    }

    public List<Item> buscarTodos() {
        return repository.findAll();
    }

    public Item buscarPorId(Long id) {
        return this.findById(id);
    }

    public List<Item> buscarPorIdProduto(Long id) {
        return repository.findByProdutoId(id);
    }

    public Item cadastrar(ItemDto dto) {
        if (repository.existsByProdutoIdAndTamanho(dto.idProduto(), dto.tamanho())) {
            throw new ItemJaCadastradoException();
        }

        Produto produto = produtoService.buscarPorId(dto.idProduto());
        return repository.save(new Item(dto,produto));
    }

    @Transactional
    public Item adicionar(Long id, Integer quantidade) {
        Item item = this.findById(id);
        return item.adicionar(quantidade);
    }

    @Transactional
    public Item remover(Long id, Integer quantidadeRemover) {
        Item item = this.findById(id);
        if (item.getQuantidade() < quantidadeRemover) {
            throw new QuantidadeInsuficienteException();
        }

        return item.remover(quantidadeRemover);
    }

    public void deletar(Long id) {
        repository.delete(this.findById(id));
    }

    private Item findById(Long id) {
        return repository.findById(id).orElseThrow(ItemNaoEncontradoException::new);
    }

}