package com.smartpoultryfarm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users") // db table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto generate
    private Long id;

    private String name;
    private String email;
    private String password;
}
