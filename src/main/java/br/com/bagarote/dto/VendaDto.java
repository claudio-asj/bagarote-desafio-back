package br.com.bagarote.dto;

import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.Venda;
import br.com.bagarote.model.VendaProduto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class VendaDto {
    private Long idVenda;
    private Long idEmpresa;
    private String nomeFantasia;
    private Long idCliente;
    private String nomeCliente;
    private LocalDateTime dataVenda;
    private MetodoPagamento metodoPagamento;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
    private BigDecimal valorAcrescimo;
    private BigDecimal valorPago;
    private List<VendaProdutoDto> produtoList;

    public VendaDto(Venda venda){
        this.idVenda = venda.getIdVenda();
        this.idEmpresa = venda.getEmpresa().getIdEmpresa();
        this.nomeFantasia = venda.getEmpresa().getNomeFantasia();
        this.idCliente = venda.getCliente().getIdCliente();
        this.nomeCliente = venda.getCliente().getNome();
        this.dataVenda = venda.getDataVenda();
        this.metodoPagamento = venda.getMetodoPagamento();
        this.valorDesconto = venda.getValorDesconto();
        this.valorAcrescimo = venda.getValorAcrescimo();
        this.valorTotal = venda.getValorTotal();
        this.valorPago = venda.getValorPago();
        List<VendaProdutoDto> produtoDtos = new ArrayList<>();
        venda.getProdutos().forEach(vendaProduto -> {
            produtoDtos.add(new VendaProdutoDto(vendaProduto));
        });

        this.produtoList = produtoDtos;
    }
}
