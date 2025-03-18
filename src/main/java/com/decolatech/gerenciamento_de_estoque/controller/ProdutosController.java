package com.decolatech.gerenciamento_de_estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.decolatech.gerenciamento_de_estoque.model.Produtos;
import com.decolatech.gerenciamento_de_estoque.service.ProdutosService;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/produtos")
public class ProdutosController {
 
    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @GetMapping
    public List<Produtos> listarProdutos() {
        return produtosService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
    
            Produtos produto = produtosService.buscarProdutoPorId(id);
            return ResponseEntity.ok(produto);
    }
    @PostMapping
    public Produtos criaProduto(@RequestBody Produtos produto) {
        return produtosService.cadastrarProduto(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Produtos> deletaProduto(@PathVariable Long id) {
        produtosService.excluirProduto(id); 
        return ResponseEntity.noContent().build();
        
    }
        @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProduto(@PathVariable Long id, @RequestBody Produtos produto) {
        Produtos produtoAtualizado = produtosService.atualizarProduto(id, produto);
        return produtoAtualizado != null ? ResponseEntity.ok(produtoAtualizado) : ResponseEntity.notFound().build();
    }
}
