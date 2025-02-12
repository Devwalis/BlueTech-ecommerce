package blue_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import blue_ecommerce.dtos.EnderecoDTO;
import blue_ecommerce.dtos.UsuarioDTO;
import blue_ecommerce.models.Endereco;
import blue_ecommerce.models.TipoUsuario;
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
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setDataNascimento(dto.dataNascimento());
        usuario.setTelefone(dto.telefone());
        usuario.setCpf(dto.cpf());
        usuario.setTipoUsuario(TipoUsuario.valueOf(dto.tipoUsuario().toUpperCase()));
        

        usuario.setEndereco(convertParaEndereco(dto.endereco()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioSalvo);


    }

    private void validarDadosUnicos(UsuarioDTO usuarioDTO){
        if(usuarioRepository.existsByEmail(usuarioDTO.email())){
            throw new IllegalArgumentException("Email já está em uso");
        }
    }
private Endereco convertParaEndereco(EnderecoDTO dto){
    return new Endereco(
        dto.getCep(),
            dto.getLogradouro(),
            dto.getCidade(),
            dto.getUf(),
            dto.getBairro(),
            dto.getComplemento()
    );
}

private UsuarioDTO converterParaDTO(Usuario usuario){
    return new UsuarioDTO(
        usuario.getNome(),
        usuario.getEmail(),
        usuario.getSenha(),
        usuario.getDataNascimento(),
        usuario.getTelefone(),
        usuario.getCpf(),
        usuario.getTipoUsuario(),
        new EnderecoDTO(
                usuario.getEndereco().getCep(),
                usuario.getEndereco().getLogradouro(),
                usuario.getEndereco().getCidade(),
                usuario.getEndereco().getUf(),
                usuario.getEndereco().getBairro(),
                usuario.getEndereco().getComplemento()
    )
    );
}

}