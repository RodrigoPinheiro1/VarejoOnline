package br.comvarejonline.projetoinicial.repository;

import br.comvarejonline.projetoinicial.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
