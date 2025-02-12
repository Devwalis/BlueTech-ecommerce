package blue_ecommerce.dtos;

import java.time.LocalDate;

import blue_ecommerce.models.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriarUsuarioDTO {
    private String nome;
    private  String email;
    private String senha;
    private LocalDate dataNascimento;
    private String telefone;
    private String cpf;
    private TipoUsuario tipouUsuario;
    private EnderecoDTO endereco;
    

}
