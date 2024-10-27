package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{

}
