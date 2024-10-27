package br.com.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.CarrinhoRequestDTO;
import br.com.serratec.dto.CarrinhoResponseDTO;
import br.com.serratec.entity.Cliente;
import br.com.serratec.service.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
//Origem service:
	@Autowired
	private CarrinhoService service;

//Metodos GET SET POST DELETE chamando o service

	// GET todos
/*	@Operation(// documentação do get
			summary = "Listar todos pedidos", description = "Retorna os dados dos pedidos")
	@ApiResponses(value = { // respostas das requisições
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Carrinho.class), mediaType = "application/json") }, description = "Retorna todos os pedidos"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@GetMapping("{id}")
	public ResponseEntity<CarrinhoResponseDTO> buscarId(@PathVariable Long id){
		return ResponseEntity.ok(service.exibirCarrinho(id));
	}*/

	// GET por id
	/*
	 * @Operation(// documentação do get summary = "Listar pedido por id",
	 * description = "Retorna os dados do pedido")
	 * 
	 * @ApiResponses(value={//respostas das requisições
	 * 
	 * @ApiResponse(responseCode = "200", content = {@Content(schema
	 * = @Schema(implementation = Carrinho.class), mediaType = "application/json")},
	 * description = "Retorna o pedido solicitado"),
	 * 
	 * @ApiResponse(responseCode = "401", description = "Erro de autenticação"),
	 * 
	 * @ApiResponse(responseCode = "403", description =
	 * "Não há permissão para acessar o recurso"),
	 * 
	 * @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
	 * 
	 * @ApiResponse(responseCode = "505", description =
	 * "Exceção interna da aplicação") } )
	 * 
	 * @GetMapping("{id}") public ResponseEntity<CarrinhoResponseDTO>
	 * buscarId(@PathVariable Long id){ return ResponseEntity.ok(service.); }
	 */

	// POST inserir pedido
	@Operation(summary = "Insere um novo pedido", description = "A resposta retorna o nome, email e telefone sem expor o id ou o cpf.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
			@Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json") }, description = "Cliente cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping("/{idPedido}/{idProduto}")
	public ResponseEntity<CarrinhoResponseDTO> inserirCarrinho(@RequestBody CarrinhoRequestDTO dto, @PathVariable Long idPedido, @PathVariable Long idProduto) {
		CarrinhoResponseDTO dtoResponse = service.inserirCarrinho(dto, idPedido, idProduto);
		return ResponseEntity.ok(dtoResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarCarrinho(@RequestBody CarrinhoRequestDTO carrinhoDTO, @PathVariable Long id) {
		CarrinhoResponseDTO carrinhoAtualizado = service.alterarCarrinho(carrinhoDTO, id);
		return ResponseEntity.ok(carrinhoAtualizado);
	}
/*
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarCarrinho(@PathVariable Long id, @RequestBody PedidoRequestDTO pedidoDTO) {
		CarrinhoResponseDTO carrinhoAtualizado = service.atualizarCarrinho(id, pedidoDTO);
		return ResponseEntity.ok(carrinhoAtualizado);
	}*/
}
