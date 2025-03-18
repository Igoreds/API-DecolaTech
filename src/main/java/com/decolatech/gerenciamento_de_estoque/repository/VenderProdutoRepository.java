package com.decolatech.gerenciamento_de_estoque.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.decolatech.gerenciamento_de_estoque.model.VenderProduto;

@Repository
public interface VenderProdutoRepository extends JpaRepository<VenderProduto, Long> {

     List<VenderProduto> findByDataVendaBetween(LocalDate startDate, LocalDate endDate);
    
}
