package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.ClienteRequestDTO;
import br.com.serratec.dto.ClienteResponseDTO;
import br.com.serratec.entity.Cliente;
import br.com.serratec.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
//Origem service:
	@Autowired
	private ClienteService service;
	
//Metodos GET SET POST DELETE chamando o service
	
	//GET todos
	@Operation(// documentação do get
			summary = "Listar todos clientes", description = "Retorna os dados dos clientes")
	@ApiResponses(value={//respostas das requisições
			@ApiResponse(responseCode = "200", 
			content = {@Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json")},
			description = "Retorna todos os clientes"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") 
			}
	)
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
		return ResponseEntity.ok(service.listarTodosClientes());
	}
	
	//GET por id
	@Operation(// documentação do get
			summary = "Listar cliente por id", description = "Retorna os dados do cliente")
	@ApiResponses(value={//respostas das requisições
			@ApiResponse(responseCode = "200", 
			content = {@Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json")},
			description = "Retorna o cliente solicitado"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") 
			}
	)
	@GetMapping("{id}")
	public ResponseEntity<ClienteResponseDTO> buscarId(@PathVariable Long id){
		return ResponseEntity.ok(service.exibirCliente(id));
	}
	
	
	//POST inserir cliente
	@Operation(summary = "Insere um novo cliente", description = "A resposta retorna o nome, email e telefone sem expor o id ou o cpf.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", 
			content = {@Content(schema = @Schema(implementation = Cliente.class), mediaType = "application/json")},
			description = "Cliente cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") 
			}
	)
	@PostMapping
	public ResponseEntity<Object> inserirCliente(@RequestBody ClienteRequestDTO dto) { 
		ClienteResponseDTO dtoResponse = service.inserirCliente(dto);
		return ResponseEntity.created(null).body(dtoResponse);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteDTO) {
		ClienteResponseDTO clienteAtualizado = service.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
