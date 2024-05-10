package br.org.serratec.exerciciojpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.exerciciojpa.model.Produto;

// A grosso modo, o repositório é a camada de acesso ao banco

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findAllByValor(BigDecimal valor); // Retorna uma lista de produtos que tem um valor
	// SELECT * FROM PRODUTOS WHERE VALOR = 500
}