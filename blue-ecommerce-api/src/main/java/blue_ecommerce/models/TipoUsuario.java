package blue_ecommerce.models;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum TipoUsuario {
    
    ADMINISTRADOR(List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))),
    CLIENTE(List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"))),
    FORNECEDOR(List.of(new SimpleGrantedAuthority("ROLE_FORNECEDOR")));

    private final List<GrantedAuthority> authorities;


    TipoUsuario(List<GrantedAuthority> authorities){
        this.authorities = authorities;
    }

    public List<GrantedAuthority> getAuthorities(){
        return authorities;
    }

}
