package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
}
