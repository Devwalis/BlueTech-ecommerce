package blue_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import blue_ecommerce.dtos.CriarUsuarioDTO;
import blue_ecommerce.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CriarUsuarioDTO cadastrar(@RequestBody CriarUsuarioDTO dto){
        return usuarioService.cadastrar(dto);
    }
    
}
