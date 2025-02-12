package blue_ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;
    private String bairro;
    private String complemento;
}
