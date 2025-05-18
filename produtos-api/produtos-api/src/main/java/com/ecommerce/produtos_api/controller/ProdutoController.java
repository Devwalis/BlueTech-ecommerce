package com.ecommerce.produtos_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.compras.client.produto.ProdutoDTO;
import com.ecommerce.produtos_api.model.Produto;
import com.ecommerce.produtos_api.servico.ProdutoService;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {



    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastroProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.salvarProduto(produto));
    }
    

    @Autowired
    private ProdutoService produtoService;
    

   
    
    

    
}
