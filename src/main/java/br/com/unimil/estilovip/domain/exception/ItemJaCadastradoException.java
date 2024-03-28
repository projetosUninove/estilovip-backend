package br.com.unimil.estilovip.domain.exception;

public class ItemJaCadastradoException extends RuntimeException {

    public ItemJaCadastradoException() {
        super("Item já cadastrado!");
    }
}
