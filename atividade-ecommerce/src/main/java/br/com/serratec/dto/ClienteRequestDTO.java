package br.com.serratec.dto;

import br.com.serratec.entity.Cliente;

public class ClienteRequestDTO {
//7 ATRIBUTOS
//Nome, Telefone, Email, Cpf, Endereco, NumeroResidencia, Complemento
//*id não precisa pois gera automaticamente
//**o endereço se obtem na api ao inserir a string do cep aqui no construtor
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private String cep;
	private String numeroResidencia;
	private String complemento;
	
//(anotação model mapper também funciona)
//construtor cheio 
	public ClienteRequestDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.numeroResidencia = cliente.getNumeroResidencia();
		this.complemento = cliente.getComplemento();
	}

//construtor vazio
	public ClienteRequestDTO() {
	}

//getset
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
