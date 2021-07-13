package com.example.Week2Demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="username")
    private String userName;

    @Column(name ="password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
