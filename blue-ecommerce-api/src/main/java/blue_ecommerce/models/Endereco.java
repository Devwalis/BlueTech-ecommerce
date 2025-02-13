package blue_ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Column(name = "cep")
    private String cep;


    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf", length = 2)
    private String uf;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "complemento")
    private String complemento;

    




    
}
