package com.redis.Redis_Implementation_Project.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String address;



}
