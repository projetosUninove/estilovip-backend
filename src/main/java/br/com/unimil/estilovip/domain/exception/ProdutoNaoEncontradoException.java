package br.com.unimil.estilovip.domain.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado!");
    }
}
