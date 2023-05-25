package br.comvarejonline.projetoinicial.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OperadorDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    private PerfilDto perfilDto;

}
