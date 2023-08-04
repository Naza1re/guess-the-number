package com.example.guessthenumber.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usersattemps")
public class User {
    public User(String name,int score) {
        this.name = name;
        this.score = score;
    }
    public User(){

    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "score")
    private int score;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
