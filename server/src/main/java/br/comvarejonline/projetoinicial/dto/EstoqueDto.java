package br.comvarejonline.projetoinicial.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstoqueDto {

    private Long id;
    private ProdutosDto produtos;
    private TipoMovimentacaoDto tipoMovimentacao;
    private Integer quantidade;

    private LocalDate data;
    private String documento;
}
