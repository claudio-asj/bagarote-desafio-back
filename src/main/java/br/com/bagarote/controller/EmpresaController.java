package br.com.bagarote.controller;

import br.com.bagarote.repository.ProdutoRepository;
import br.com.bagarote.service.EmpresaService;
import br.com.bagarote.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.model.Empresa;
import br.com.bagarote.repository.EmpresaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmpresaController {
	
	private final EmpresaRepository empresaRepository;
	private final EmpresaService empresaService;
	private final ProdutoRepository produtoRepository;
	private final ProdutoService produtoService;

	//lista das empresas
	@GetMapping("empresa")
	public ResponseEntity<?> getaAll() {
	    return ResponseEntity.ok().body(empresaService.listaEmpresas());
    }


	@GetMapping("empresa/{idEmpresa}")
	public ResponseEntity<?> getByIdEmpresa(@PathVariable Long idEmpresa) {
	    return ResponseEntity.ok().body(empresaRepository.findById(idEmpresa).orElse(null));
    }

	//lista de clientes da empresa
	@GetMapping("empresa/{idEmpresa}/clientes")
	public ResponseEntity<?> getClientesByEmpresa(@PathVariable Long idEmpresa){
		return ResponseEntity.ok().body(empresaService.clientesByEmpresa(idEmpresa));
	}

	@PostMapping("empresa")
	public ResponseEntity<?> create(@RequestBody br.com.bagarote.model.Empresa createEmpresa) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(createEmpresa));
    }
	@PutMapping("empresa/{idEmpresa}")
	public ResponseEntity<?> update(@PathVariable Long idEmpresa, @RequestBody Empresa updateEmpresa) {
		Empresa empresa = empresaRepository.findById(idEmpresa).orElse(null);
		BeanUtils.copyProperties(updateEmpresa, empresa);
	    return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
    }

	//lista todos os produtos de uma empresa
	@GetMapping("empresa/{idEmpresa}/produtos")
	public ResponseEntity<?> getProdutosByEmpresa(@PathVariable Long idEmpresa){
		return ResponseEntity.ok().body(produtoService.getProductByIdEmpresa(idEmpresa));
	}
}
