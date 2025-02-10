package br.com.bagarote.form;

import br.com.bagarote.dto.ProdutoDto;
import br.com.bagarote.dto.ProdutoVendaDto;
import br.com.bagarote.model.MetodoPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class VendaForm {
    private Long idEmpresa;
    private Long idCliente;
    private LocalDateTime dataVenda;
    private MetodoPagamento metodoPagamento;
    private List<ProdutoVendaDto> produtos;
}
