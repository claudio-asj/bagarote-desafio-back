package br.com.bagarote.dto;

import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.Venda;
import br.com.bagarote.model.VendaProduto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class VendaProdutoDto {
    private Long idProduto;
    private int quantidade;
    public VendaProdutoDto(VendaProduto vendaProduto){
        this.idProduto = vendaProduto.getVendaProdutoId().getProduto().getIdProduto();
        this.quantidade =vendaProduto.getQtd();
    }
}
