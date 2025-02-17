package br.com.bagarote.form;

import br.com.bagarote.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoForm {
    private String produto;
    private String descricao;
    private BigDecimal valorBase;
    private byte[] imagemProduto;
    private Long idEmpresa;

    public ProdutoForm(Produto produto){
        this.produto = produto.getProduto();
        this.descricao = produto.getDescricao();
        this.valorBase = produto.getValorBase();
        this.imagemProduto = produto.getImagemProduto();
        this.idEmpresa = produto.getEmpresa().getIdEmpresa();
    }
}