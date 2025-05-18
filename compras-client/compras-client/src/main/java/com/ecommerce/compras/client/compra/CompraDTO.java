package com.ecommerce.compras_api.dto;

import java.time.LocalDate;
import java.util.List;

import com.ecommerce.compras_api.model.Item;

public class CompraDTO {
    
    private Long id;
    private ClienteDTO cliente;
    private double total;
    private LocalDate data;
    private List<Item> itens;
}
