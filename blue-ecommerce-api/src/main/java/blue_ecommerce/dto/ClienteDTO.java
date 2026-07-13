package blue_ecommerce.dto;

public record ClienteDTO(


    Long id,
    String nome,
    String cpf,
    String email,
    String telefone,
    Integer idade,
    String cep,
    String logradouro,
    String cidade,
    String uf,
    String bairro,
    String numero
) {
} 
