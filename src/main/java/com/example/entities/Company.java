package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.jdbc.env.internal.LobTypes;

import java.util.HashSet;
import java.util.Set;

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

    private String imagen;

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees = new HashSet<>();

    public Company(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
