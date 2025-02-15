package blue_ecommerce.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

 
    private String cep;   
    private String logradouro;
    private String cidade;   
    private String uf;
    private String bairro;
    private String complemento;

    




    
}
