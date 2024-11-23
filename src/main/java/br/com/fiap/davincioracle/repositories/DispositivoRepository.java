package br.com.fiap.davincioracle.repositories;

import br.com.fiap.davincioracle.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
