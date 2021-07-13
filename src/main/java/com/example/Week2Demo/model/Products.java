package com.example.Week2Demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
public class Products {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, message = "Name should have at least 2 character")
    @Column(name="name")
    private String name;
    @NotNull
    @Size(min = 2, message = "Description should have at least 10 character")
    @Column(name="description")
    private String description;

    public Products(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Products(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
