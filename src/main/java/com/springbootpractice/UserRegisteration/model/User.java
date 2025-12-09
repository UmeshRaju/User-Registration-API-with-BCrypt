package com.springbootpractice.UserRegisteration.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String userpassword;
}
