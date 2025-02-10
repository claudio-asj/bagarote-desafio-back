package br.com.bagarote.dto;

import br.com.bagarote.model.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
    private Long idProduto;
    private String produto;

    public ProdutoDto(Produto produto){
        this.idProduto = produto.getIdProduto();
        this.produto = produto.getProduto();
    }
}
