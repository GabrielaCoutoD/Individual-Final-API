package br.com.serratec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Optional<Produto> findById(Long id);
	/* METODOS DE BUSCA
	List<Usuario> findByNameIs(String name);
	List<Usuario> findByNameEquals(String name);
	List<Usuario> findByNameOrderByName(String name);
	List<Usuario> findByNameOrderByNameAsc(String name);
	List<Usuario> findByNameOrderByNameDesc(String name);
	
	List<Usuario> findByNomeIs(String parametro);
	List<Usuario> findByNomeEquals(String parametro);
	List<Usuario> findByNomeIsNot(String parametro);
	List<Usuario> findByNomeIdade(String parametro, Integer valor);
	List<Usuario> findByNomeIsNull();
	List<Usuario> findByNomeStartingWith(String prefixo);
	List<Usuario> findByNomeContaining(String texto);
	List<Usuario> findByNameLike(String padraoLike);
	List<Usuario> findByIdadeBetween(Integer inicio, Integer fim);
	List<Usuario> findByIdadeIn(Collection<Integer> valores);
	List<Usuario> findByIdadeLessThan(Integer valor);
	List<Usuario> findByIdadeLessThanEqual(Integer valor);
	List<Usuario> findByIdadeGreaterThan(Integer valor);
	List<Usuario> findByIdadeGreaterThanEqual(Integer valor);
	*/
}
