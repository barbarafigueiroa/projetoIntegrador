package org.artemanha.ecommerce.repository;

import java.util.List;

import org.artemanha.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto>findAllByCodigoContainingIgnoreCase(String codigo);

	public List<Produto>findAllByNomeContainingIgnoreCase(String nome);
}