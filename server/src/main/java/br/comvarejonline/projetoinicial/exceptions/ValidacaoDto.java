package br.comvarejonline.projetoinicial.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidacaoDto {

    private String campo;
    private String erro;


}
