package com.decolatech.gerenciamento_de_estoque.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decolatech.gerenciamento_de_estoque.model.VenderProduto;
import com.decolatech.gerenciamento_de_estoque.repository.VenderProdutoRepository;


@Service
public class ExtratoVendasService {
    
    @Autowired
    private final VenderProdutoRepository venderProdutoRepository;
    public ExtratoVendasService(VenderProdutoRepository venderProdutoRepository) {
        this.venderProdutoRepository = venderProdutoRepository;
    }
    public List<VenderProduto> gerarExtrato(LocalDate startDate, LocalDate endDate) {
        return venderProdutoRepository.findByDataVendaBetween(startDate, endDate);
    }
}
