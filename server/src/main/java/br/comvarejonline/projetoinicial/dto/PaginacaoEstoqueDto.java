package br.comvarejonline.projetoinicial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PaginacaoEstoqueDto {

    private Long id;
    private LocalDate data;
    private ProdutosDto produtos;
    private TipoMovimentacaoDto tipoMovimentacao;
    private Integer quantidade;
    private String motivo;
    private String documento;

}
