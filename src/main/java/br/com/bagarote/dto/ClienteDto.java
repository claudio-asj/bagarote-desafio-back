package br.com.bagarote.dto;

import br.com.bagarote.model.Cliente;
import br.com.bagarote.model.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {

    private Long idCliente;
    private String nome;

    public ClienteDto(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
    }
}
