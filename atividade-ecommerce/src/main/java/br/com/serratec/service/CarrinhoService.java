package br.com.serratec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.CarrinhoRequestDTO;
import br.com.serratec.dto.CarrinhoResponseDTO;
import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Pedido;
import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CarrinhoRepository;
import br.com.serratec.repository.ClienteRepository;
import br.com.serratec.repository.PedidoRepository;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository repository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	//CRUDs
	
	// Inserir um novo carrinho (POST)
	public CarrinhoResponseDTO inserirCarrinho(CarrinhoRequestDTO requisicaoDTO, Long idPedido, Long idProduto) {
		var carrinho = new Carrinho();
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		Optional<Produto> produto = produtoRepository.findById(idProduto);

		// adiciona as informações do cliente
		carrinho.setPedido(pedido.get());
		carrinho.setProduto(produto.get());
		
		carrinho.setQuantidade(requisicaoDTO.getQuantidade());
		
		
		carrinho.setDesconto(requisicaoDTO.getDesconto());
		/*
		if(carrinho.getValorTotal()==null) {
			carrinho.setValorTotal(0.0);
		}
		if(requisicaoDTO.getValorTotal()==null) {
			requisicaoDTO.setValorTotal(0.0);
		}
		if(requisicaoDTO.getProduto().getPreco()==null) {
			requisicaoDTO.getProduto().setPreco(0.0);
		}
		
		Double valorS = carrinho.getValorTotal();
		Double valor = requisicaoDTO.getProduto().getPreco().doubleValue();
		Double valorT = valor + valorS;
		requisicaoDTO.setValorTotal(valorT);
		 */
		
		carrinho.setValorTotal(requisicaoDTO.getValorTotal());
		carrinho = repository.save(carrinho);

		// retorna
		return new CarrinhoResponseDTO(carrinho);
	}
	
	// Alterar um carrinho (PUT)
		public CarrinhoResponseDTO alterarCarrinho(CarrinhoRequestDTO requisicaoDTO, Long idCarrinho) {
			Optional<Carrinho> carrinhoOptional = repository.findById(idCarrinho);
			if (carrinhoOptional.isEmpty()) {
				throw new RuntimeException("Carrinho não encontrado.");
			}
			Carrinho carrinho = carrinhoOptional.get();
/*
			// adiciona as informações do cliente
//			carrinho.setPedido(requisicaoDTO.getPedido());
//			carrinho.setProduto(requisicaoDTO.getProduto());
			if(carrinho.getQuantidade()==null) {
				carrinho.setQuantidade(0);
			}
			if(requisicaoDTO.getQuantidade()==null) {
				requisicaoDTO.setQuantidade(0);
			}
			Integer quantidade = carrinho.getQuantidade();
			Integer quantidadeAdicionada = requisicaoDTO.getQuantidade();
			Integer quantidadeTotal = quantidade + quantidadeAdicionada;
			carrinho.setQuantidade(quantidadeTotal);
			
			carrinho.setDesconto(requisicaoDTO.getDesconto());
			if(carrinho.getValorTotal()==null) {
				carrinho.setValorTotal(0.0);
			}
			if(requisicaoDTO.getValorTotal()==null) {
				requisicaoDTO.setValorTotal(0.0);
			}
			Double valorS = carrinho.getValorTotal();
			Double valor = requisicaoDTO.getProduto().getPreco().doubleValue();
			Double valorT = valor + valorS;
			requisicaoDTO.setValorTotal(valorT);
			*/
			
			carrinho.setQuantidade(requisicaoDTO.getQuantidade());
			carrinho.setDesconto(requisicaoDTO.getDesconto());
			carrinho.setValorTotal(requisicaoDTO.getValorTotal());
			
			carrinho = repository.save(carrinho);

			// retorna
			return new CarrinhoResponseDTO(carrinho);
		}
	

}
