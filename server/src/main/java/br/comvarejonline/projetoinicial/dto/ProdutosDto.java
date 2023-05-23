package br.comvarejonline.projetoinicial.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutosDto {

    private Long id;
    private UUID codigoDeBarra;

    @NotNull
    private String nome;

    @Positive
    private Integer qtdMinima;
    @Positive
    private BigDecimal saldoInicial;

}
