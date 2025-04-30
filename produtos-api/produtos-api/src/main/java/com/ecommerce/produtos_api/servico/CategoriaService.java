package com.ecommerce.produtos_api.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.produtos_api.model.Categoria;
import com.ecommerce.produtos_api.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
    
}
