package br.comvarejonline.projetoinicial.repository;

import br.comvarejonline.projetoinicial.model.Estoque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {

    Page<Estoque> findByProdutosIdOrDataMovimentacao(Long id, LocalDate date, Pageable pageable);

}
