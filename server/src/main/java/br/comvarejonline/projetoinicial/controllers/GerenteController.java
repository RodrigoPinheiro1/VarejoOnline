package br.comvarejonline.projetoinicial.controllers;

import br.comvarejonline.projetoinicial.Service.implem.GerenteServiceimplemts;
import br.comvarejonline.projetoinicial.dto.CadastroEstoqueDto;
import br.comvarejonline.projetoinicial.dto.EstoqueDto;
import br.comvarejonline.projetoinicial.dto.GerenteDto;
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
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    private GerenteServiceimplemts gerenteServiceimplemts;


    @PostMapping
    public ResponseEntity<GerenteDto> cadastroProduto(@RequestBody @Valid GerenteDto gerenteDto, UriComponentsBuilder builder) {

        GerenteDto dto = gerenteServiceimplemts.cadastrarGerente(gerenteDto);

        URI uri = builder.path("/gerente/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}
