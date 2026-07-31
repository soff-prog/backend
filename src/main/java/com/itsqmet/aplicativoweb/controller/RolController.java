package com.itsqmet.aplicativoweb.controller;

import com.itsqmet.aplicativoweb.model.Rol;
import com.itsqmet.aplicativoweb.repository.RolRepository;
import com.itsqmet.aplicativoweb.service.RolService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController extends BaseCrudController<Rol> {
    private final RolService rolService;

    public  RolController(RolRepository roles, RolService rolService){
        super(roles);
        this.rolService = rolService
    }

    @Override
    public List<Rol> listar(){
        return  rolService.listar();
    }

    @Override
    public ResponseEntity<Rol> crear(@Valid @RequestBody Rol body){
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.crear(body));
    }

    @Override
    public Rol actualizar(@PathVariable Long id, @Valid @RequestBody Rol body){
        return  rolService.actualizar(id,body);
    }

    @Override
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
