package br.com.bagarote.controller;

import br.com.bagarote.form.ProdutoForm;
import br.com.bagarote.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.model.Produto;
import br.com.bagarote.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProdutoController {
	private final ProdutoRepository produtoRepository;
	private final ProdutoService produtoService;
	
	@GetMapping("produto")
	public ResponseEntity<?> getAll() {
	    return ResponseEntity.ok().body(produtoRepository.findAll());
    }

	//get de produto com detalhes
	@GetMapping("produto/{idProduto}")
	public ResponseEntity<?> getByIdProduto(@PathVariable Long idProduto) {
	    return ResponseEntity.ok().body(produtoService.getProdutoDetalhe(idProduto));
    }
	@PostMapping("produto")
	public ResponseEntity<?> create(@RequestBody ProdutoForm createProduto) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(createProduto));
    }
	@PutMapping("produto/{idProduto}")
	public ResponseEntity<?> update(@PathVariable Long idProduto, @RequestBody Produto updateProduto) {
		Produto produto = produtoRepository.findById(idProduto).orElse(null);
		if(produto == null)
			ResponseEntity.status(HttpStatus.OK).build();
	    return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
    }
}
