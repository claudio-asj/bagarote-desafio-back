package br.com.bagarote.controller;

import br.com.bagarote.dto.VendaDto;
import br.com.bagarote.form.VendaForm;
import br.com.bagarote.service.VendaService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bagarote.model.Venda;
import br.com.bagarote.repository.VendaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VendaController {
	
	private final VendaRepository vendaRepository;

	private final VendaService vendaService;
	
	@GetMapping("venda")
	public ResponseEntity<?> getAll() {
	    return ResponseEntity.ok().body(vendaRepository.findAll());
    }

	//criar venda
	@PostMapping("venda")
	public ResponseEntity<?> criarVenda(@RequestBody VendaForm form) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.criarVenda(form));
    }
	@GetMapping("venda/{idVenda}")
	public ResponseEntity<?> getVendaByIdVenda(@PathVariable Long idVenda) {
	    return ResponseEntity.ok().body(vendaRepository.findById(idVenda).orElse(null));
    }

	//get de venda baseado no id da empresa e do clientes
	@GetMapping("venda/empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<?> getVendaByIdEmpresaAndIdCliente(@PathVariable Long idEmpresa, @PathVariable Long idCliente, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok().body(vendaService.listarVendas(idEmpresa, idCliente, page, size));
	}
}
