package br.comvarejonline.projetoinicial.dto;

import br.comvarejonline.projetoinicial.model.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GerenteCadastroDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Long perfilId;



}
