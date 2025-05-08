package com.ecommerce.produtos_api.model;

import com.ecommerce.produtos_api.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_produtos")
public class Produto {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;


    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String descricao;
    

    @Column(nullable = false)
    private Double precoDouble;


  @Column(nullable = false)
  private String caracteristicas;

  @Column(nullable = false)
  private String avaliacoes;

    @ManyToOne
    @JoinColumn
    private Categoria categoria;



    public ProdutoDTO converterParaDTO(){
      ProdutoDTO dto = new ProdutoDTO();

      dto.setId(id);
      dto.setNome(nome);
      dto.setCodigo(codigo);
      dto.setDescricao(descricao);
      dto.setPreco(precoDouble);
      dto.setCaracteristicas(caracteristicas);
      dto.setCategoria(categoria.getNome());

      return dto;
    }



}
