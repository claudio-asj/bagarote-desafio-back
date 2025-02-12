package br.com.bagarote.service;

import br.com.bagarote.dto.ClienteDto;
import br.com.bagarote.dto.EmpresaDto;
import br.com.bagarote.model.Cliente;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.repository.ClienteRepository;
import br.com.bagarote.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private  final ClienteRepository clienteRepository = null;


    public List<EmpresaDto> listaEmpresas(){
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaDto> response = new ArrayList<>();
        empresas.forEach(empresa -> {
            response.add(new EmpresaDto(empresa));
        });

        return response;
    }

    public List<ClienteDto> clientesByEmpresa(Long idEmpresa){
        List<Cliente> clientes = clienteRepository.findByEmpresaIdEmpresa(idEmpresa);
        List<ClienteDto> response = new ArrayList<>();
        clientes.forEach(cliente -> {
            response.add(new ClienteDto(cliente));
        });
        return response;
    }
}
