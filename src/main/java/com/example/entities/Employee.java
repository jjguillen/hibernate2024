package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Double salary;

    private String email;

    @OneToOne
    private Address address;

    @ManyToOne
    private Company company;

    public Employee(String name, String lastName, Double salary, String email) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
    }
}
