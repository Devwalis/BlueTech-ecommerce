package blue_ecommerce.dto;



import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;


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




) {
} 
    




