package br.comvarejonline.projetoinicial.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class TipoMovimentacaoDto {
    private BigDecimal entrada;
    private BigDecimal saida;
    private BigDecimal saldoInicial;
    private BigDecimal ajusteEntrada;
    private BigDecimal ajusteSaida;

    private BigDecimal saldo;

    public TipoMovimentacaoDto(BigDecimal entrada, BigDecimal saida, BigDecimal saldoInicial, BigDecimal ajusteEntrada,
                               BigDecimal ajusteSaida) {
        this.entrada = entrada;
        this.saida = saida;
        this.saldoInicial = saldoInicial;
        this.ajusteEntrada = ajusteEntrada;
        this.ajusteSaida = ajusteSaida;
        BigDecimal sum1 = entrada.add(saldoInicial);
        BigDecimal soma = sum1.add(ajusteEntrada);

        BigDecimal subtract = saida.subtract(ajusteSaida);

       this.saldo = soma.subtract(subtract);
    }



}
