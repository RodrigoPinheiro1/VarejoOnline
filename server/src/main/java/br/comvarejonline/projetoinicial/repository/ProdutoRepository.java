package br.comvarejonline.projetoinicial.repository;

import br.comvarejonline.projetoinicial.dto.ProdutosDto;
import br.comvarejonline.projetoinicial.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos,Long> {


}
