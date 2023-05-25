package br.comvarejonline.projetoinicial.controllers;

import br.comvarejonline.projetoinicial.Service.implem.OperadorServiceimplemts;
import br.comvarejonline.projetoinicial.dto.CadastroOperadorDto;
import br.comvarejonline.projetoinicial.dto.OperadorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/operador")
public class OperadorController {

    @Autowired
    private OperadorServiceimplemts operadorServiceimplemts;


    @PostMapping
    public ResponseEntity<OperadorDto> cadastroProduto(@RequestBody @Valid CadastroOperadorDto cadastroOperadorDto, UriComponentsBuilder builder) {

        OperadorDto dto = operadorServiceimplemts.cadastrarOperador(cadastroOperadorDto);

        URI uri = builder.path("/operador/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}
