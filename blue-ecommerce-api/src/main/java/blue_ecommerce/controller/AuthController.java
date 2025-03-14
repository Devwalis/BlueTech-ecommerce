package blue_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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

    

@Autowired
private TokenService tokenService;

@Autowired
private AuthenticationManager authenticationManager;


 


@PostMapping("/login")
public ResponseEntity<UsuarioDTO> login(@RequestBody AutenticacaoDTO dto){
    try{
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenService.generateToken(usuario);

        UsuarioDTO usuarioDTO = new UsuarioDTO(
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getDataNascimento(),
            usuario.getTelefone(),
            usuario.getCpf(),
            usuario.getTipoUsuario(),
            token
        );

        return ResponseEntity.ok(usuarioDTO);

    } catch (BadCredentialsException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

}

    

