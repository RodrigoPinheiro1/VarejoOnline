package br.comvarejonline.projetoinicial.dto;

import br.comvarejonline.projetoinicial.model.Perfil;
import lombok.Data;

@Data
public class CadastroOperadorDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    private Long perfilId;

}
