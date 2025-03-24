package com.anchorsbiz.basic.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable =false)
    private String password;


    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    private String address;
}
