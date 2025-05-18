package blue_ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.ecommerce.compras.client.usuario.AutenticacaoDTO;

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
public ResponseEntity<Map<String, Object>> login(@RequestBody AutenticacaoDTO dto){
    try{
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        String token = tokenService.generateToken(usuario);

       
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("tipoUsuario", usuario.getTipoUsuario());
        response.put("nome", usuario.getNome());

        return ResponseEntity.ok(response);

    } catch (BadCredentialsException e){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body( Map.of("mensagem", "Credenciais inválidas"));

                
            }
        }
}
    
        

    

