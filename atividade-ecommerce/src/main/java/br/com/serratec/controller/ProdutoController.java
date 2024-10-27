package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CategoriaRepository;
import br.com.serratec.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Operation(summary = "Lista todos os produtos", description = "A resposta lista os dados dos produtos id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = Produto.class), mediaType = "application/json") }, description = "Retorna todos os produtos"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@Operation(summary = "Insere um novo produto", description = "A resposta retorna o nome e id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
			@Content(schema = @Schema(implementation = Produto.class), mediaType = "application/json") }, description = "Produto cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto p) {

		if (p.getCategoria() == null || !categoriaRepository.existsById(p.getCategoria().getId())) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		Produto novoProduto = produtoRepository.save(p);

		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @Valid @RequestBody Produto p) {
		if (!produtoRepository.existsById(id)) {

			return ResponseEntity.notFound().build();
		}

		if (p.getCategoria() == null || !categoriaRepository.existsById(p.getCategoria().getId())) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Categoria não encontrada
		}

		p.setId(id);

		Produto produtoAtualizado = produtoRepository.save(p);

		return ResponseEntity.ok(produtoAtualizado);
	}
}
