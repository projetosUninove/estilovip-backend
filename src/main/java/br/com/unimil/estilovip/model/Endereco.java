package br.com.unimil.estilovip.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logadouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String complemento;
}
