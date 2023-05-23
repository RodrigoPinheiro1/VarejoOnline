package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.Service.EstoqueService;
import br.comvarejonline.projetoinicial.dto.CadastroEstoqueDto;
import br.comvarejonline.projetoinicial.dto.EstoqueDto;
import br.comvarejonline.projetoinicial.dto.PaginacaoEstoqueDto;
import br.comvarejonline.projetoinicial.exceptions.ProductNotFoundException;
import br.comvarejonline.projetoinicial.model.Estoque;
import br.comvarejonline.projetoinicial.model.Produtos;
import br.comvarejonline.projetoinicial.repository.EstoqueRepository;
import br.comvarejonline.projetoinicial.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EstoqueServiceimplemts implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EstoqueDto cadastrarEstoque(CadastroEstoqueDto cadastroEstoqueDto) {

        Estoque estoque = modelMapper.map(cadastroEstoqueDto, Estoque.class);

        findById(estoque.getProdutos().getId());

        estoque.setProdutos(produtoRepository.getById(cadastroEstoqueDto.getProdutosId()));
        estoqueRepository.save(estoque);

        return modelMapper.map(estoque, EstoqueDto.class);

    }

    @Override
    public Page<PaginacaoEstoqueDto> paginacao(Long id, LocalDate fimDate, Pageable pageable) {


      return  estoqueRepository.findByProdutosIdOrDataMovimentacao(id,fimDate, pageable)
              .map(estoque -> modelMapper.map(estoque, PaginacaoEstoqueDto.class));


    }
    public void findById(Long id) {
        produtoRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }


}
