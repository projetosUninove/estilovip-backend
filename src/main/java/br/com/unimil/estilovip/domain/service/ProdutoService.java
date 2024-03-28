package br.com.unimil.estilovip.domain.service;

import br.com.unimil.estilovip.domain.exception.ProdutoNaoEncontradoException;
import br.com.unimil.estilovip.domain.model.Produto;
import br.com.unimil.estilovip.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Page<Produto> buscarTodos(Pageable page) {
        return repository.findAll(page);
    }

    public Produto buscar(Long id) {
        return this.buscarPorId(id);
    }

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Long id){
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }

    private Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }

}