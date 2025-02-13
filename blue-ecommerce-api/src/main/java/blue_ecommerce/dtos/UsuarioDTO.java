package blue_ecommerce.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import blue_ecommerce.models.TipoUsuario;



public record UsuarioDTO(
    String nome,
    String email,
    String senha,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataNascimento,
    String telefone,
    String cpf,
    String tipoUsuario,
    EnderecoDTO endereco
    
){

public TipoUsuario getTipoUsuarioEnum(){
    return TipoUsuario.valueOf(tipoUsuario.toUpperCase());
}
}

