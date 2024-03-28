package br.com.unimil.estilovip.domain.repository;

import br.com.unimil.estilovip.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
