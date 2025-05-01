package com.ecommerce.produtos_api.servico;

import org.springframework.stereotype.Service;

import com.ecommerce.produtos_api.dto.ProdutoDTO;
import com.ecommerce.produtos_api.model.Produto;

@Service
public class PordutoService {

    public ProdutoDTO salvarProduto(Produto produto){
        return produtoRepository.save(produto).converterParaDTO();
    }
    
}
