package br.comvarejonline.projetoinicial.repository;

import br.comvarejonline.projetoinicial.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<Operador,Long> {
}
