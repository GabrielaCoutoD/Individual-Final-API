package br.com.serratec.entity;

import java.math.BigDecimal;
import java.util.List;

import br.com.serratec.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Enumerated
	private StatusPedido status;//virar o enum
	
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	//private LocalDate data; // aaaa/mm/dd
	//private LocalTime hora; // hh:mm 
	
	// Usando Carrinho como entidade intermediária, para detalhar a quantidade com com os produtos e descontos 
	@OneToMany(mappedBy = "pedido")
    private List<Carrinho> carrinho; 
	
	
	//get set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
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

	
	
	    // Método para calcular o total do pedido
	    
	    public List<Carrinho> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}
	/*
		public BigDecimal calcularTotal() {
	        return carrinho.stream()
	                .map(Carrinho::calcularValorTotal)
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	    }*/
	}
	
	
	

