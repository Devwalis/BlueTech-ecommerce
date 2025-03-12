package blue_ecommerce.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import blue_ecommerce.models.Cliente;


public class TokenService {
    //Gerar um token a partir do cliente/usuario
    public String generateToken (Cliente cliente){
        Algorithm algorithm  = Algorithm.HMAC256(SECRET_KEY);

        return JWT.create()
            .withIssuer(TOKEN_ISSUER)
            .withASubject(cliente.getCpf())
            .wiwthExpiresAt(_expirationDate())
            .withClaim("id", cliente.getId())
            .sign(algorithm);

    }



    // Obtém o sujeito (cliente/usuario) a partir do token
    public String getSubject(String token){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);


        return KWT.require(algorithm)
            .withIssuer(TOKEN_ISSUER)
            .build()
            .verify(token)
            .getSubject();
    }

    //Gera a data de expiração do token JWt

    private Instant _expirationDate(){
        return LocalDateTime.now().plusDays().toInstant(ZoneOffset.of("-03:00"));
    }


@Value("${spring.security.secret-key}")
private String SECRET_KEY;


@Value("${spring.security.token-issuer}")
private String TOKEN_ISSUER;

    
}
