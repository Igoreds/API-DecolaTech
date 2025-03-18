package com.decolatech.gerenciamento_de_estoque.service;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.decolatech.gerenciamento_de_estoque.model.Produtos;
import com.decolatech.gerenciamento_de_estoque.model.VenderProduto;
import com.decolatech.gerenciamento_de_estoque.repository.ProdutoRepository;
import com.decolatech.gerenciamento_de_estoque.repository.VenderProdutoRepository;

@Service
public class venderProdutoService {

    
    private final VenderProdutoRepository venderProdutoRepository; 
    private final ProdutoRepository produtoRepository;


    public venderProdutoService(VenderProdutoRepository venderProdutoRepository, ProdutoRepository produtoRepository) {
        this.venderProdutoRepository = venderProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    public String venderProduto(Long produtoId, int quantidadeVendida) {
        Optional<Produtos> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            Produtos produto = produtoOptional.get();

            if (produto.getQuantidade() >= quantidadeVendida) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
                produtoRepository.save(produto);

                double valorTotal = produto.getPreco() * quantidadeVendida;
                VenderProduto venda = new VenderProduto(produtoId, quantidadeVendida, valorTotal);
                venderProdutoRepository.save(venda);

                return "Venda realizada com sucesso!";
            } else {
                return "Estoque insuficiente!";
            }
        } else {
            return "Produto não encontrado!";
        }
    }
}
    



