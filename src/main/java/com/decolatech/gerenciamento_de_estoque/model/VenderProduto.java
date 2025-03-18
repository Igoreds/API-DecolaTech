package com.decolatech.gerenciamento_de_estoque.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vender_produto")
@Data
public class VenderProduto {
    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produtoId;
    private int quantidadeVendida;
    private double valorTotal;
    private LocalDate dataVenda;

    public VenderProduto(Long produtoId, int quantidadeVendida, double valorTotal) {
        this.produtoId = produtoId;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
        this.dataVenda = LocalDate.now(); 
    }
}
    

