package br.com.bagarote.dto;

import br.com.bagarote.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDetalheDto {
    private Long idProduto;
    private String produto;
    private String descricao;
    private BigDecimal valorBase;
    private byte[] imagemProduto;
    private Long idEmpresa;

    //usar optimal n é recomendado
    public ProdutoDetalheDto(Optional<Produto> produto){
        if(produto.isPresent()){
            this.idProduto = produto.get().getIdProduto();
            this.produto = produto.get().getProduto();
            this.descricao = produto.get().getDescricao();
            this.valorBase = produto.get().getValorBase();
            this.imagemProduto = produto.get().getImagemProduto();
            this.idEmpresa = produto.get().getEmpresa().getIdEmpresa();
        }
    }

}
