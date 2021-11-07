package com.example.geoApiTest.model;


import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique=true)
    private String email;


    private String password;
    private String name;


    public Account() {
    }

    public Account(Role role, String email, String password, String name) {
        this.role = role;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
