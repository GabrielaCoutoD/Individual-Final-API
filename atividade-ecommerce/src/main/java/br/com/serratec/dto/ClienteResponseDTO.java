package br.com.serratec.dto;

import br.com.serratec.entity.Cliente;

public class ClienteResponseDTO {
//atributos que vão pro front end:
	private String nome;
	private String email;
	private String telefone;
	
//construtor que vai pro listar:
	public ClienteResponseDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
	}
	
//construtor vazio:
	public ClienteResponseDTO() {
		// TODO Auto-generated constructor stub
	}

//gets sets:
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
