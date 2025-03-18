package com.decolatech.gerenciamento_de_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decolatech.gerenciamento_de_estoque.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    
}
