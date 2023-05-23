package br.comvarejonline.projetoinicial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    private TipoMovimentacao tipoMovimentacao;


    @Positive
    private Integer quantidade;

    private LocalDate dataMovimentacao;

    private String motivo;

    private String documento;

    @OneToOne
    private Produtos produtos;





}
