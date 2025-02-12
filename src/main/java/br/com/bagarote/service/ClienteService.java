package br.com.bagarote.service;

import br.com.bagarote.dto.ClienteDto;
import br.com.bagarote.model.Cliente;
import br.com.bagarote.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteDto> getClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clienteDtos = new ArrayList<>();
        clientes.forEach(cliente -> {
            clienteDtos.add(new ClienteDto(cliente));
        });

        return clienteDtos;
    }
}
