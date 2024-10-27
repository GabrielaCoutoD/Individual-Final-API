package br.com.serratec.entity;

import java.math.BigDecimal;


import br.com.serratec.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	private Integer quantidade;
	
	//private List<Produto> itens;
			
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	private Double desconto; 	//BigDecimal é o mais preciso
	private Double valorTotal; 

//	@Enumerated (EnumType.STRING)
//	private StatusPedido enumStatus;
	
	//get set	
	public Long getId() {
		return id;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	// Método para calcular o valor total
	/*
    public BigDecimal calcularValorTotal() {
        BigDecimal valorProduto = produto.getPreco(); // Assumindo que Produto tem um campo 'preco' do tipo BigDecimal
        BigDecimal quantidadeBD = BigDecimal.valueOf(quantidade);
        BigDecimal valorTotal = valorProduto.multiply(quantidadeBD);

        if (desconto != null) {
            valorTotal = valorTotal.subtract(desconto);
        }

        return valorTotal;
    }*/
}
	

