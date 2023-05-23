package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.Service.ProdutoService;
import br.comvarejonline.projetoinicial.dto.AtualizaProdutoDto;
import br.comvarejonline.projetoinicial.dto.ProdutosDto;
import br.comvarejonline.projetoinicial.exceptions.ProductNotFoundException;
import br.comvarejonline.projetoinicial.model.Produtos;
import br.comvarejonline.projetoinicial.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class ProdutoServiceImplements implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProdutosDto cadastrarProduto(ProdutosDto produtosDto) {


        Produtos produtos = modelMapper.map(produtosDto, Produtos.class);

        produtos.setCodigoDeBarra(UUID.randomUUID());
        produtoRepository.save(produtos);

       return modelMapper.map(produtos,ProdutosDto.class);

    }

    @Override
    public ProdutosDto atualizarProduto(AtualizaProdutoDto dto, Long id) {


        findById(id);
        Produtos produtos = produtoRepository.getById(id);


        produtos.setId(id);
        produtos.setNome(dto.getNome());
        produtos.setQtdMinima(dto.getQtdMinima());

        produtoRepository.save(produtos);

        return modelMapper.map(produtos,ProdutosDto.class);

    }

    public void findById(Long id) {
        produtoRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
