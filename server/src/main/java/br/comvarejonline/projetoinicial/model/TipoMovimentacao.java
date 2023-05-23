package br.comvarejonline.projetoinicial.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
@NoArgsConstructor
public class TipoMovimentacao {


    private BigDecimal entrada;
    private BigDecimal saida;
    private BigDecimal saldoInicial;
    private BigDecimal ajusteEntrada;
    private BigDecimal ajusteSaida;

}
