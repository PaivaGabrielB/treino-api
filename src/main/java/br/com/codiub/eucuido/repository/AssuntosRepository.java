package br.com.codiub.eucuido.repository;

import br.com.codiub.eucuido.model.entity.Assuntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuntosRepository extends JpaRepository<Assuntos, Long> {
}
