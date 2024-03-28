package br.com.unimil.estilovip.domain.exception;

public class ItemNaoEncontradoException extends RuntimeException {

    public ItemNaoEncontradoException() {
        super("Item não encontrado!");
    }
}
