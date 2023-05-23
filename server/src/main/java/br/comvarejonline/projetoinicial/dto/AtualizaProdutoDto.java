package br.comvarejonline.projetoinicial.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class AtualizaProdutoDto {

    private Long id;

    @NotNull
    private String nome;
    @Positive

    private Integer qtdMinima;


}
