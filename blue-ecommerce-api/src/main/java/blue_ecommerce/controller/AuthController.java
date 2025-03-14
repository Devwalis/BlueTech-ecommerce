package blue_ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blue_ecommerce.dtos.AutenticacaoDTO;
import blue_ecommerce.dtos.UsuarioDTO;


@RestController
@RequestMapping("/auth")
public class AuthController {
    


    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO dto) {
        //TODO: process POST request
        Authentituion authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        
        
        return entity;
    }
    
}
