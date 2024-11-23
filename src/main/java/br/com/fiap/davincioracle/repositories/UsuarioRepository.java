package br.com.fiap.davincioracle.repositories;

import br.com.fiap.davincioracle.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}