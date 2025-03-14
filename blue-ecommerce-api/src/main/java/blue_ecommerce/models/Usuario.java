package blue_ecommerce.models;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import blue_ecommerce.dtos.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;






@Data
@AllArgsConstructor
@Entity(name = "tb_usuarios")
public class Usuario  implements UserDetails {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nome;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column( nullable = false, unique = true)
    private String cpf;


    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String telefone;


    @Column(nullable = false)
    private Boolean administrador;

    @Column(nullable = false)
    private Boolean fornecedor;

    @Column(nullable = false)
    private Boolean cliente;


    public Usuario(){
        this.administrador = Boolean.FALSE;
        this.fornecedor = Boolean.FALSE;
        this.cliente = Boolean.FALSE;
    }

    public String getTipoUsuario(){
        if(this.administrador) return "ADMINISTRADOR";
        if(this.fornecedor) return "FORNECEDOR";
        return "CLIENTE";
    }


    public UsuarioDTO converterParaDTO(){
        UsuarioDTO dto = new UsuarioDTO();

        dto.setNome(nome);
        dto.setEmail(email);
        dto.setTelefone(telefone);
        dto.setAdministrador(administrador);
        dto.setFornecedor(fornecedor);
        dto.setCliente(cliente);
        dto.setToken(null);

        return dto;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        if(administrador){
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(fornecedor){
            return List.of(new SimpleGrantedAuthority("ROlE_FORNECEDOR"));

        }
        if(cliente){
            return List.of(new SimpleGrantedAuthority("Role_CLIENTE"));

        }
        return null;
    }

    @Override
    public String getPassword(){
        return senha;

    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;

    }

    @Override
    public boolean isAccountNonLocked(){
        return true;



}

    @Override
    public boolean isCredentialsNonExpired(){   
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}














    

