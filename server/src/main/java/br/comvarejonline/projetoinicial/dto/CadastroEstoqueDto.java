package br.comvarejonline.projetoinicial.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class CadastroEstoqueDto {

    private Long id;
    private TipoMovimentacaoDto tipoMovimentacao;

    @NotNull
    private Long produtosId;
    @Positive
    private Integer quantidade;
    @NotNull
    private LocalDate dataMovimentacao;
    @NotNull
    private String documento;

    private String motivo;

}
