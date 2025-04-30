package com.ecommerce.produtos_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


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
    private String descrição;
    

    @Column(nullable = false)
    private Double precoDouble;


  @Column(nullable = false)
  private String caracteristicas;

  @Column(nullable = false)
  private String avaliacoes;

    @ManyToOne
    @JoinColumn Categoria categoria;



}
