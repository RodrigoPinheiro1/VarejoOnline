package br.comvarejonline.projetoinicial.controllers;

import br.comvarejonline.projetoinicial.Service.implem.EstoqueServiceimplemts;
import br.comvarejonline.projetoinicial.dto.CadastroEstoqueDto;
import br.comvarejonline.projetoinicial.dto.EstoqueDto;
import br.comvarejonline.projetoinicial.dto.PaginacaoEstoqueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueServiceimplemts estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueDto> cadastroProduto(@RequestBody @Valid CadastroEstoqueDto cadastroEstoqueDto, UriComponentsBuilder builder) {

        EstoqueDto dto = estoqueService.cadastrarEstoque(cadastroEstoqueDto);

        URI uri = builder.path("/produto/{id}").buildAndExpand(cadastroEstoqueDto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public Page<PaginacaoEstoqueDto> paginacao(@RequestParam(required = false) Long produtosId,
                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                               @RequestParam(required = false) LocalDate inicioData,
                                               @PageableDefault(sort = "produtosId", value = 2)
                                               Pageable pageable) {


        return estoqueService.paginacao(produtosId, inicioData, pageable);


    }

}
