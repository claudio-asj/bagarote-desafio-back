package br.com.bagarote.service;

import br.com.bagarote.dto.ProdutoDetalheDto;
import br.com.bagarote.dto.VendaDto;
import br.com.bagarote.form.VendaForm;
import br.com.bagarote.model.*;
import br.com.bagarote.repository.ClienteRepository;
import br.com.bagarote.repository.EmpresaRepository;
import br.com.bagarote.repository.ProdutoRepository;
import br.com.bagarote.repository.VendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@AllArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final EmpresaRepository empresaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;


    public Page<VendaDto> listarVendas(Long idEmpresa, Long idCliente, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Venda> vendas = vendaRepository.findByEmpresaAndCliente(idEmpresa, idCliente, pageable);

        return vendas.map(this::convertToDTO);

    }

    private VendaDto convertToDTO(Venda venda) {
        return new VendaDto(venda);
    }

    public VendaDto criarVenda(VendaForm vendaForm){
        Venda venda = new Venda();
        venda.setMetodoPagamento(vendaForm.getMetodoPagamento());
        venda.setDataVenda(vendaForm.getDataVenda());

        // Validar se a empresa existe
        Empresa empresa = empresaRepository.findById(vendaForm.getIdEmpresa()).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
        venda.setEmpresa(empresa);

        // Validar se o cliente existe e pertence à empresa
        Cliente cliente = clienteRepository.findById(vendaForm.getIdCliente()).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        if (!cliente.getEmpresa().getIdEmpresa().equals(empresa.getIdEmpresa())) {
            throw new IllegalArgumentException("Cliente não pertence à empresa informada");
        }
        venda.setCliente(cliente);



        //falta calcular total
        vendaForm.getProdutos().forEach(produtoForm -> {
            Produto produto = produtoRepository.findById(produtoForm.getIdProduto()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
            BigDecimal valor = produto.getValorBase();
            valor.multiply(BigDecimal.valueOf(produtoForm.getQuantidade()));
            venda.setValorTotal(venda.getValorTotal().add(valor));
        });

        Venda newVenda = vendaRepository.save(venda);
        return new VendaDto(newVenda);
    }
}
