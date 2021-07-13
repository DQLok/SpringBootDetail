package com.lokdq.springboot_loda.security;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data // lombok
public class User { // liên kết với DB
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}
