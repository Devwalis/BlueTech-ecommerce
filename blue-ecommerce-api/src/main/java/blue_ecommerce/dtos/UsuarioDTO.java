package blue_ecommerce.dtos;

import java.time.LocalDate;

import blue_ecommerce.models.TipoUsuario;



public record UsuarioDTO(
    String nome,
    String email,
    String senha,
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

