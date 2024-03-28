package br.com.unimil.estilovip.domain.model;

import br.com.unimil.estilovip.domain.dto.UsuarioRequisicaoDto;
import br.com.unimil.estilovip.domain.enumerated.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    @CPF
    private String cpf;
    @Column(unique = true)
    private String email;
    private String senha;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario(UsuarioRequisicaoDto dto) {
        this.nome = dto.nome();
        this.sobrenome = dto.sobrenome();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.senha = dto.senha();
        this.endereco = new Endereco(dto.endereco());
        this.tipoUsuario = TipoUsuario.CLIENTE;
    }
}
