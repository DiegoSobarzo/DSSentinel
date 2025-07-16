package com.vigilancia.controller;

import com.vigilancia.model.Usuario;
import com.vigilancia.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repo;

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        Usuario user = repo.findByEmail(email).orElse(null);
        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
        return ResponseEntity.ok(Map.of("nombre", user.getNombre()));
    }
}