package br.comvarejonline.projetoinicial.dto;

import br.comvarejonline.projetoinicial.model.Gerente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.PushBuilder;

@Data
@NoArgsConstructor
public class GerenteDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;



}
