package br.com.unimil.estilovip.model;

import br.com.unimil.estilovip.enumerated.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
