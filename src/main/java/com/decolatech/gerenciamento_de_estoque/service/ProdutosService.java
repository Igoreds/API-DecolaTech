package com.decolatech.gerenciamento_de_estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.decolatech.gerenciamento_de_estoque.exeptions.RecursoNaoEncontradoExeption;
import com.decolatech.gerenciamento_de_estoque.model.Produtos;
import com.decolatech.gerenciamento_de_estoque.repository.ProdutoRepository;

@Service
public class ProdutosService {
    private final ProdutoRepository produtoRepository;

    public ProdutosService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos> listarProdutos() {
        return produtoRepository.findAll();
    }
    public Produtos cadastrarProduto(Produtos produto) {
        return produtoRepository.save(produto);
    }
    public Produtos buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                    .orElseThrow(()-> new RecursoNaoEncontradoExeption("Produto com ID " + id + " não encontrado"));
    }

    public Produtos atualizarProduto(Long id, Produtos produtoAtualizado) {
        if (produtoRepository.existsById(id)) {
            Produtos produtoExistente = produtoRepository.findById(id).orElse(null);
            
            if (produtoExistente != null) {
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setCategoria(produtoAtualizado.getCategoria());
                produtoExistente.setPreco(produtoAtualizado.getPreco());
                produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
                
                return produtoRepository.save(produtoExistente);
            }
        }
        return null;
    }

    public boolean excluirProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            throw new RecursoNaoEncontradoExeption("Produto com ID " + id + " não encontrado");
        }
    }
    
}


