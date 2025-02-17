package br.com.bagarote.service;

import br.com.bagarote.dto.ProdutoDetalheDto;
import br.com.bagarote.dto.ProdutoDto;
import br.com.bagarote.form.ProdutoForm;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.model.Produto;
import br.com.bagarote.repository.EmpresaRepository;
import br.com.bagarote.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final EmpresaRepository empresaRepository;

    public List<ProdutoDto> getProductByIdEmpresa(Long idEmpresa){
        List<Produto> produtos = produtoRepository.findByEmpresaIdEmpresa(idEmpresa);
        List<ProdutoDto> response = new ArrayList<>();

        produtos.forEach(produto -> {
            response.add(new ProdutoDto(produto));
            System.out.println(produto.getProduto());
        });

        return response;
    }

    public ProdutoDetalheDto getProdutoDetalhe(Long idProduto){
        return new ProdutoDetalheDto(produtoRepository.findById(idProduto));
    }

    public ProdutoDto criarProduto(ProdutoForm form){
        Produto novoProduto = new Produto();

        // Validar se a empresa existe
        Empresa empresa = empresaRepository.findById(form.getIdEmpresa()).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
        novoProduto.setEmpresa(empresa);

        novoProduto.setProduto(form.getProduto());
        novoProduto.setDescricao(form.getDescricao());
        novoProduto.setImagemProduto(form.getImagemProduto());
        novoProduto.setValorBase(form.getValorBase());

        Produto produtoCriado = produtoRepository.save(novoProduto);

        return new ProdutoDto(produtoCriado);
    }
}
