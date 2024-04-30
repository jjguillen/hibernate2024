package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Company company;

    public Employee(String name, String lastName, Double salary, String email) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
