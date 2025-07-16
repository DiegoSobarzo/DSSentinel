package com.vigilancia.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String nombre;
    // Getters y Setters
}