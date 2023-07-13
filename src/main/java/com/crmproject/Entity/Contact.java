package com.crmproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "contacts")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fist_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "mobile",nullable = false,unique = true)
    private String mobile;

    @Column(name = "source",nullable = false)
    private String source;
}