package blue_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import blue_ecommerce.dtos.UsuarioDTO;
import blue_ecommerce.models.Usuario;
import blue_ecommerce.repository.UsuarioRepository;
import jakarta.transaction.Transactional;



@Service
public class UsuarioService {


   

    @Transactional
    public Usuario cadastrar(Usuario usuario){
        validarDadosUnicos(dto);

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(passwordEncoder.encode(dto.senha)));
        usuario.set
        


        switch (dto.tipoUsuario().toUpperCase()) {
            case "ADMINISTRADOR":
                usuario.setAdministrador(true);
                
                break;
            case "FORNECEDOR":
                usuario.setFornecedor(true);
                break;
            default:
                usuario.setCliente(true);
                break;
        }

      


    }
   

    private void validarDadosUnicos(UsuarioDTO dto){
        if(usuarioRepository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Email já Cadastrado");
        }
        if(usuarioRepository.existsByCpf(dto.cpf())){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
    }



    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    }




