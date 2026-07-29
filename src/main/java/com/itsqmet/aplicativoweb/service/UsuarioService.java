package com.itsqmet.aplicativoweb.service;

import com.itsqmet.aplicativoweb.model.Usuario;
import com.itsqmet.aplicativoweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    public Optional<Usuario>ObtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public Usuario guardarUsuario(Usuario usuario){
        if (usuario.getContrasenia()!=null && !usuario.getContrasenia().isBlank()){
            usuario.setContrasenia((passwordEncoder.encode(usuario.getContrasenia())));


        }
        return usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }


}
