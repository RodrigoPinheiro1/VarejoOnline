package br.comvarejonline.projetoinicial.Service;


import br.comvarejonline.projetoinicial.dto.CadastroEstoqueDto;
import br.comvarejonline.projetoinicial.dto.EstoqueDto;
import br.comvarejonline.projetoinicial.dto.PaginacaoEstoqueDto;
import br.comvarejonline.projetoinicial.dto.TipoMovimentacaoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface EstoqueService {
    EstoqueDto cadastrarEstoque(CadastroEstoqueDto cadastroEstoqueDto);

    Page<PaginacaoEstoqueDto> paginacao (Long id, LocalDate toDate,  Pageable pageable);

}
