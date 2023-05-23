package br.comvarejonline.projetoinicial.Service;

import br.comvarejonline.projetoinicial.dto.AtualizaProdutoDto;
import br.comvarejonline.projetoinicial.dto.ProdutosDto;

public interface ProdutoService {


    ProdutosDto cadastrarProduto (ProdutosDto produtosDto);


    ProdutosDto atualizarProduto(AtualizaProdutoDto produtosDto, Long id);
}
