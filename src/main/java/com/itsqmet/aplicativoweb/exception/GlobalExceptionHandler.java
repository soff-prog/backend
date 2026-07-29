package com.itsqmet.aplicativoweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    //ALUMNO
    @ExceptionHandler(AlumnoNoEncontradoException.class)
    public ResponseEntity<String> manejarNoEncontrado(AlumnoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //DATOS INVALIDOS (Lo vamos a reutilizar para alumnos y materia)
    @ExceptionHandler(DatosInvalidosException.class)
    public ResponseEntity<String> manejarDatosInvalidos(DatosInvalidosException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    //NOTA
    @ExceptionHandler(NotaNoEncontradaException.class)
    public ResponseEntity<String> manejarNotaNoEncontrada(NotaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //MATERIA
    @ExceptionHandler(MateriaNoEncontradaException.class)
    public ResponseEntity<String> manejarMateriaNoEncontrada(MateriaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //ERRORES GENERALES
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarErroresGenerales(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error inesperado: " + ex.getMessage());
    }

}
