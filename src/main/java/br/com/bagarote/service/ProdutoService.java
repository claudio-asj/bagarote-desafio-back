package br.com.bagarote.service;

import br.com.bagarote.dto.ProdutoDetalheDto;
import br.com.bagarote.dto.ProdutoDto;
import br.com.bagarote.model.Produto;
import br.com.bagarote.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDto> getProductByIdEmpresa(Long idEmpresa){
        List<Produto> produtos = produtoRepository.findByEmpresaIdEmpresa(idEmpresa);
        List<ProdutoDto> response = new ArrayList<>();

        produtos.forEach(produto -> {
            response.add(new ProdutoDto(produto));
        });

        return response;
    }

    public ProdutoDetalheDto getProdutoDetalhe(Long idProduto){
        return new ProdutoDetalheDto(produtoRepository.findById(idProduto));
    }
}
