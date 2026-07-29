package com.itsqmet.aplicativoweb.repository;


import com.itsqmet.aplicativoweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    List<Usuario>findByUsuarioIgnorecase(String usuario);
    Long countByRolId(Long rolId);
}
