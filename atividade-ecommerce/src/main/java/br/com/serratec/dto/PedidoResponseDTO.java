package br.com.serratec.dto;

import br.com.serratec.entity.Pedido;
import br.com.serratec.enums.StatusPedido;

public class PedidoResponseDTO {
	
		//atributos que vão pro front end:
			private String nome;
			private String email;
			private String telefone;
			private StatusPedido status;
			
		//construtor que vai pro listar:
			public PedidoResponseDTO(Pedido pedido) {
				this.nome = pedido.getCliente().getNome();
				this.email = pedido.getCliente().getEmail();
				this.telefone = pedido.getCliente().getTelefone();
				this.status = pedido.getStatus();
				
			}
			
		//construtor vazio:
			public PedidoResponseDTO() {
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

			public StatusPedido getStatus() {
				return status;
			}

			public void setStatus(StatusPedido status) {
				this.status = status;
			}
			
		}

