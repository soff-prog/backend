package com.itsqmet.aplicativoweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService autenticacion;

    public AuthController(AuthService autenticacion){
        this.autenticacion = autenticacion
    }

    @GetMapping("/csrf")
    public Map<String, String> csrf(CsrfToken token){
        return Map.of("token", token.getToken(), "headerName", token.getHeaderName());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletRequest servletRequest){
        AutheService.ResultadoLogin resultado = autenticacion.autenticar(request);
        if (resultado == null){
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
        }
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(resultado.autenticacion());
        SecurityContextHolder.setContext(context);
        servletRequest.getSession(true).setAttribute("SPRING_SECURITY_CONTEXT", context);
        return ResponseEntity.ok(resultado.respuesta());
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication){
        if (authentication == null){
            return ResponseEntity.status(401).body(Map.of("error", "No autenticado"));
        }
        return ResponseEntity.ok(authentication.obtenerSesion(authentication));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }
}
