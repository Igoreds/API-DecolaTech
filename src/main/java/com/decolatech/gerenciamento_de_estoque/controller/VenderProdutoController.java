package com.decolatech.gerenciamento_de_estoque.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decolatech.gerenciamento_de_estoque.service.venderProdutoService;


@RestController
@RequestMapping("/api/vendas")
public class VenderProdutoController {
    
    private final venderProdutoService venderProdutoService;

    public VenderProdutoController(venderProdutoService venderProdutoService) {
        this.venderProdutoService = venderProdutoService;
    }

    @PostMapping("/vender")
    public ResponseEntity<String> venderProduto(@RequestParam Long produtoId, @RequestParam int quantidadeVendida) {
        String mensagem = venderProdutoService.venderProduto(produtoId, quantidadeVendida);
        return ResponseEntity.ok(mensagem); 
    }
}

