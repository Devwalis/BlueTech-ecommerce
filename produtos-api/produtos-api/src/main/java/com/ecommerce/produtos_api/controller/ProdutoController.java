package com.ecommerce.produtos_api.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.produtos_api.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @PostMapping
    public ResponseEntity <ProdutoDTO>(@RequestBodys Produto produto) {
   
        
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }
    

    @GetMapping
    public ResponseEntity <Page<ProdutoDTO>> listarProdutos(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.ok).body(produtoService.listarProdutos1(pageable));    
    }
    
    

    
}
