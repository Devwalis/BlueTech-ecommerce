package com.ecommerce.produtos_api.servico;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ecommerce.produtos_api.dto.ProdutoDTO;
import com.ecommerce.produtos_api.model.Produto;
import com.ecommerce.produtos_api.repository.ProdutoRepository;

@Service
public class ProdutoService {

public ProdutoDTO salvarProduto(Produto produto){
    return produtoRepository.save(produto).converterParaDTO();

}

public ProdutoDTO obterProdutoPeloCodigo(String codigo){
    Optional<Produto> produto = produtoRepository.findByCodigo(codigo);

    if(produto.isPresent()){
        return produto.get().converterParaDTO();
    }


    return null;
}


public Page<ProdutoDTO> listarProdutos(Pageable pageable){
    return produtoRepository.findAll(pageable).map(Produto::converterParaDTO);
}

@Autowired
private ProdutoRepository produtoRepository;

}
