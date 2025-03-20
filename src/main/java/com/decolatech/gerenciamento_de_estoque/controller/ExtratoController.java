package com.decolatech.gerenciamento_de_estoque.controller;

import java.time.LocalDate;
import java.util.List;
import com.decolatech.gerenciamento_de_estoque.model.VenderProduto; //

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decolatech.gerenciamento_de_estoque.service.ExtratoVendasService;

@RestController
@RequestMapping("/api/extrato")
public class ExtratoController {

    @Autowired
    private final ExtratoVendasService extratoVendasService;
    public ExtratoController(ExtratoVendasService extratoVendasService) {
        this.extratoVendasService = extratoVendasService;
    }
    @GetMapping
    public ResponseEntity<List<VenderProduto>> gerarExtrato(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<VenderProduto> extrato = extratoVendasService.gerarExtrato(start, end);
        return ResponseEntity.ok(extrato);
    }
    
}
