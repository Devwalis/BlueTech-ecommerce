package com.ecommerce.produtos_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.produtos_api.model.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{
    Optional<Produto> findByIdOptional(Long id);
    boolean findByCategoria(String categoria);
}
