package br.comvarejonline.projetoinicial.controllers;

import br.comvarejonline.projetoinicial.Service.implem.ProdutoServiceImplements;
import br.comvarejonline.projetoinicial.dto.AtualizaProdutoDto;
import br.comvarejonline.projetoinicial.dto.ProdutosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoServiceImplements produtoService;


    @PostMapping
    public ResponseEntity<ProdutosDto> cadastroProduto(@RequestBody @Valid ProdutosDto produtosDto, UriComponentsBuilder builder) {

        ProdutosDto dto = produtoService.cadastrarProduto(produtosDto);


        URI uri = builder.path("/produto/{id}").buildAndExpand(produtosDto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDto> atualizarProduto(@RequestBody  @Valid AtualizaProdutoDto produtosDto, @PathVariable Long id){

        ProdutosDto dto = produtoService.atualizarProduto(produtosDto, id);

        return ResponseEntity.ok(dto);
    }


}
