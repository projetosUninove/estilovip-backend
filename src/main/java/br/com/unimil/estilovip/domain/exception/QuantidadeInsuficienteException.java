package br.com.unimil.estilovip.domain.exception;

public class QuantidadeInsuficienteException extends RuntimeException {
    public QuantidadeInsuficienteException() {
        super("Quantidade de item insulficiente!");
    }
}
