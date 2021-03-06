package org.artemanha.ecommerce.repository;

import java.util.List;

import org.artemanha.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Camila Bazante
 * @since 1.2
 * 
 * Criação do repository da classe categoria
 *
 */
@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List<Categoria> findAllByFormaPagamentoContainingIgnoreCase(String formaPagamento);

	public List<Categoria> findAllByArtesanalContainingIgnoreCase(String artesanal);

}
