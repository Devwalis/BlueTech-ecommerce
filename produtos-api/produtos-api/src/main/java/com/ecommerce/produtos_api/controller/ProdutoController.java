package com.ecommerce.produtos_api.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.produtos_api.dto.ProdutoDTO;
import com.ecommerce.produtos_api.model.Produto;
import com.ecommerce.produtos_api.servico.PordutoService;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController /*~~(Could not parse as Java)~~>*//*~~(Could not parse as Java)~~>*/{

    private final PordutoService pordutoService;

   

    @PostMapping
    public ResponseEntity<ProdutoDTO>(@RequestBody Produto produto) {
   
        
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
    }
    

    @GetMapping
    public ResponseEntity <Page<ProdutoDTO>> listarProdutos(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.ok).body(produtoService.listarProdutos1(pageable));    
    }
    
    

    
}
