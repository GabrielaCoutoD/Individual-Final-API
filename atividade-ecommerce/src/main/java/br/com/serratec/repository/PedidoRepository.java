package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.dto.PedidoRequestDTO;
import br.com.serratec.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	Optional<Pedido> findById(Long id);
//	@Override
//	default List<Pedido> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
