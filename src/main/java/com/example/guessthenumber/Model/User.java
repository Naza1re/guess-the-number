package com.example.guessthenumber.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public User(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


}
