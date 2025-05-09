package com.ecommerce.compras_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/compras")
public class CompraController {
    
    @PostMapping("")
    public ResponseEntity postMethodName(@RequestBody String entity) {
        
        
        return entity;
    }
    
}
