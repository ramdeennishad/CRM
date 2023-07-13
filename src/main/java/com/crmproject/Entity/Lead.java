package com.crmproject.Entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 45)

    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)

    private String lastName;

    @Column(name = "email", nullable = false, length = 128, unique = true)

    private String email;

    @Column(name = "mobile", nullable = false, length = 10, unique = true)

    private String mobile;
    private String source;


}


