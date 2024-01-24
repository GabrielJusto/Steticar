package br.com.bonatto.steticar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bonatto.steticar.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

    UserDetails findByLogin(String login);
    
}
