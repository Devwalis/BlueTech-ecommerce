package com.ecommerce.compras.client.usuario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import blue_ecommerce.models.Usuario;




public record UsuarioDTO(
    String nome,
    String email,
    String senha,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataNascimento,
    String telefone,
    String cpf,
    String tipoUsuario,
    String token
    
){

    public UsuarioDTO(Usuario usuario, String token) {
        this(
            usuario.getNome(),
            null,
            null,
            null, 
           null,
           null,
            usuario.getTipoUsuario(), 
            token
        );
    }
}

