package blue_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blue_ecommerce.dtos.AutenticacaoDTO;
import blue_ecommerce.dtos.UsuarioDTO;
import blue_ecommerce.models.Usuario;
import blue_ecommerce.service.TokenService;


@RestController
@RequestMapping("/auth")
public class AuthController {
    


    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO dto) {
        //TODO: process POST request
        Authentication authentication = AuthenticationManager.authenticated();
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        
        

        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenService.gerarToken(usuario);


        UsuarioDTO usuarioDTO = usuario.converterParaDTO();
        usuarioDTO.setToken(token);


        
        
        return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);
    }

 @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;
}

    

