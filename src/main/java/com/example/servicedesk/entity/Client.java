package com.example.servicedesk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    // 🔹 Construtor padrão (obrigatório para JPA)
    public Client() {
    }

    // 🔹 Construtor usado para criar cliente novo
    public Client(String name) {
        this.name = name;
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
