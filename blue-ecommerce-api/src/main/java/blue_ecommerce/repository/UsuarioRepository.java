package blue_ecommerce.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blue_ecommerce.models.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    
    Optional<Usuarios> findByEmail(String email);
    boolean existByEmail(String email);
}
