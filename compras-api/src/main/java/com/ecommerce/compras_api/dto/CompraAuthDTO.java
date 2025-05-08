package com.ecommerce.compras_api.dto;

import com.ecommerce.compras_api.model.Compra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraAuthDTO {


    private Compra compra;
    private String token;
    
}
