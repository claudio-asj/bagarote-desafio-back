package br.com.bagarote.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long>{

    Page<Venda> findByEmpresaAndCliente(Long idEmpresa, Long idCliente, Pageable pageable);

    Page<Venda> findByEmpresaIdEmpresaAndClienteIdCliente(Long idEmpresa, Long idCliente, Pageable pageRequest);

    List<Venda> findByEmpresaIdEmpresa(Long idEmpresa);

    Optional<Venda> findByIdVendaAndEmpresaIdEmpresa(Long idVenda, Long idEmpresa);
}
