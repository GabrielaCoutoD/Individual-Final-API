package br.com.serratec.dto;

import br.com.serratec.entity.Pedido;


public class PedidoRequestDTO {
	//o construtor do swagger se baseia nos getters e setters daqui
	
	// 7 ATRIBUTOS
	// Nome, Telefone, Email, Cpf, Endereco, NumeroResidencia, Complemento
	// *id não precisa pois gera automaticamente
	// **o endereço se obtem na api ao inserir a string do cep aqui no construtor
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private String cep;
	private String numeroResidencia;
	private String complemento;
	//private LocalDate data;
	//private LocalTime hora;
	private String status;
	private Long clienteId;
	
	// (anotação model mapper também funciona)
	// construtor cheio
	public PedidoRequestDTO(Pedido pedido) {
		
	this.nome = pedido.getCliente().getNome();
	this.telefone = pedido.getCliente().getTelefone();
	this.email = pedido.getCliente().getEmail();
	this.cpf = pedido.getCliente().getCpf();
	this.cep = pedido.getCliente().getEndereco().getCep();
	this.numeroResidencia = pedido.getCliente().getNumeroResidencia();
	this.complemento = pedido.getCliente().getComplemento();
	//this.data = pedido.getData();
	//this.hora = pedido.getHora();
	this.status = pedido.getStatus().toString();
	this.clienteId = pedido.getCliente().getId();
	}

	// construtor vazio
	
	public PedidoRequestDTO() {
	}
	
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getStatus() {
		return status;
	}

	// getset
/*
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
*/
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

/*	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}*/


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public Long getClienteId() {
		// TODO Auto-generated method stub
		return null;
	}

}
