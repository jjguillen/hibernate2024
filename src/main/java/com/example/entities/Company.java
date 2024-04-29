package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    @Lob
    private byte[] imagen;

    public Company(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
