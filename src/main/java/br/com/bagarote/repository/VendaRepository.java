package br.com.bagarote.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{

    Page<Venda> findByEmpresaAndCliente(Long idEmpresa, Long idCliente, Pageable pageable);
}
