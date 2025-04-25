package com.ecommerce.produtos_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.produtos_api.model.Produto;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @PostMapping
    public ResponseEntity <ProdutoDTO>(@RequestBody Produto produto) {
   
        
        return entity;
    }
    

    
}
