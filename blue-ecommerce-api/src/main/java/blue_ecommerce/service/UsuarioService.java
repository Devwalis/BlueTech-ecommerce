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


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Transactional
    public UsuarioDTO cadastrar(UsuarioDTO dto){
        validarDadosUnicos(dto);
        
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setEmail(dto.email());
        usuario.setCpf(dto.cpf());
        usuario.setTelefone(dto.telefone());
        usuario.setDataNascimento(dto.dataNascimento());

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

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioSalvo);



    }
    private UsuarioDTO converterParaDTO(Usuario usuario){
        return new UsuarioDTO(
            usuario.getNome(),
            usuario.getEmail(),
            null,
            usuario.getDataNascimento(),
            usuario.getTelefone(),
            usuario.getCpf(),
            usuario.getTipoUsuario()
            );
    }


    private void validarDadosUnicos(UsuarioDTO dto){
        if(usuarioRepository.existsByEmail(dto.email())){
            throw new IllegalArgumentException("Email já Cadastrado");
        }
        if(usuarioRepository.existsByCpf(dto.cpf())){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
    }
    
    }




