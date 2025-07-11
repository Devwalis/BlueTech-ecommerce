package com.ecommerce.compras.client.compra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraAuthDTO {


    private CompraAuthDTO compra;
    private String token;
    
}
