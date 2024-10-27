package br.com.serratec.dto;

import java.math.BigDecimal;

import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Pedido;
import br.com.serratec.entity.Produto;

public class CarrinhoResponseDTO {
	
		//atributos que vão pro front end:
			private Produto produto;

			private Integer quantidade;

			private Pedido pedido;

			private Double desconto; // BigDecimal é o mais preciso
			private Double valorTotal;

			// (anotação model mapper também funciona)
			// construtor cheio
			public CarrinhoResponseDTO(Carrinho carrinho) {
				this.produto = carrinho.getProduto();
				this.quantidade = carrinho.getQuantidade();
				this.pedido = carrinho.getPedido();
				this.desconto = carrinho.getDesconto();
				this.valorTotal = carrinho.getValorTotal();
			}

			// construtor vazio
			public CarrinhoResponseDTO() {
			}

			// gets sets
			public Produto getProduto() {
				return produto;
			}

			public void setProduto(Produto produto) {
				this.produto = produto;
			}

			public Integer getQuantidade() {
				return quantidade;
			}

			public void setQuantidade(Integer quantidade) {
				this.quantidade = quantidade;
			}

			public Pedido getPedido() {
				return pedido;
			}

			public void setPedido(Pedido pedido) {
				this.pedido = pedido;
			}

			public Double getDesconto() {
				return desconto;
			}

			public void setDesconto(Double desconto) {
				this.desconto = desconto;
			}

			public Double getValorTotal() {
				return valorTotal;
			}

			public void setValorTotal(Double valorTotal) {
				this.valorTotal = valorTotal;
			}

		}

