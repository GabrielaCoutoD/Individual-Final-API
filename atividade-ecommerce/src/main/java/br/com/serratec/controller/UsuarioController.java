package br.com.serratec.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.CadastroRequestDTO;
import br.com.serratec.dto.LoginRequestDTO;
import br.com.serratec.dto.LoginResponseDTO;
import br.com.serratec.entity.Usuario;
import br.com.serratec.repository.UsuarioRepository;
import br.com.serratec.seguranca.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

	private final UsuarioRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;


	public UsuarioController(UsuarioRepository repository, PasswordEncoder passwordEncoder, 
	                             TokenService tokenService) {
	        this.repository = repository;
	        this.passwordEncoder = passwordEncoder;
	        this.tokenService = tokenService;
	}

	@Operation(summary = "Faz um login via token", description = "A resposta um nome de usuario e seu token pra mexer no sistema.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
			@Content(schema = @Schema(implementation = Usuario.class), mediaType = "application/json") }, description = "Usuario logado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequestDTO body) {
		Usuario usuario = this.repository.findByEmail(body.email())
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
		if (passwordEncoder.matches(body.senha(), usuario.getSenha())) {
			String token = this.tokenService.generateToken(usuario);
			return ResponseEntity.ok(new LoginResponseDTO(usuario.getNome(), token));
		}
		return ResponseEntity.badRequest().build();
	}

	@Operation(summary = "Insere um novo cadastro de administrador", description = "A resposta retorna um novo cadastro")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", content = {
			@Content(schema = @Schema(implementation = Usuario.class), mediaType = "application/json") }, description = "Administrador cadastrado com sucesso"),
			@ApiResponse(responseCode = "401", description = "Erro de autenticação"),
			@ApiResponse(responseCode = "403", description = "Não há permissão para acessar o recurso"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@PostMapping("/cadastro")
	public ResponseEntity<LoginResponseDTO> register(@RequestBody CadastroRequestDTO body) {
		Optional<Usuario> usuario = this.repository.findByEmail(body.email());

		if (usuario.isEmpty()) {
			Usuario newUser = new Usuario();
			newUser.setNome(body.nome());
			newUser.setEmail(body.email());
			newUser.setSenha(passwordEncoder.encode(body.senha()));
			newUser.setRole(body.role());
			this.repository.save(newUser);

			String token = this.tokenService.generateToken(newUser);
			return ResponseEntity.ok(new LoginResponseDTO(newUser.getNome(), token));
		}
		return ResponseEntity.badRequest().build();
	}	
}