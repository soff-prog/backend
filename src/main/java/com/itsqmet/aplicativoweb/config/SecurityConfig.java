package com.itsqmet.aplicativoweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //Enciende la seguridad web en toda la aplicación
public class SecurityConfig {

    // Herramienta para encriptar las contraseñas de los usuarios
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Administrador principal que procesa el inicio de sesión
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    //Filtro principal para definir las reglas de acceso a las rutas
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Activa la configuración para conectar al frontend
                .cors(cors -> {
                })

                // Desactiva la protección CSRF para poder probar POST, PUT y DELETE sin bloqueos
                .csrf(AbstractHttpConfigurer::disable)

                // Se define quien puede entrar a cada ruta
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/auth/**").permitAll()

                        // Administrador puede gestionar cursos, docentes y representantes
                        .requestMatchers("/api/cursos/**").hasRole("ADMIN")
                        .requestMatchers("/api/docentes/**").hasRole("ADMIN")
                        .requestMatchers("/api/representantes/**").hasRole("ADMIN")

                        // Administradores y docentes pueden tomar asistencias y ver alumnos
                        .requestMatchers("/api/alumnos/**").hasAnyRole("ADMIN", "DOCENTE")
                        .requestMatchers("/api/asistencias/**").hasAnyRole("ADMIN", "DOCENTE")

                        // Los representantes solo ven información de sus estudiantes
                        .requestMatchers("/api/mis-representados/**").hasRole("REPRESENTANTE")

                        // Cualquier otra ruta no definida requiere iniciar sesión
                        .anyRequest().authenticated()
                )

                // Solo una sesión activa por usuario a la vez
                .sessionManagement(session -> session
                        .maximumSessions(1)
                )

                // Mensajes de error personalizados cuando falla el acceso
                .exceptionHandling(ex -> ex
                        // Error 401: Intenta entrar a una ruta protegida sin haber iniciado sesión
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setContentType("application/json;charset=UTF-8");
                            response.setStatus(401);
                            response.getWriter().write(
                                    "{\"error\": \"No autenticado. Debes hacer login primero.\"}"
                            );
                        })

                        // Error: 403: Ya iniciado sesión, pero no tiene el rol necesario para esa ruta
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setContentType("application/json;charset=UTF-8");
                            response.setStatus(403);
                            response.getWriter().write(
                                    "{\"error\": \"Acceso denegado. No tienes permisos para esta acción.\"}"
                            );
                        })
                );

        return http.build();
    }

}
