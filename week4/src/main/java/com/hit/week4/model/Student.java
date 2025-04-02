package com.hit.week4.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, columnDefinition = "DATE")
    private String birthDay;

    @Column(nullable = false, columnDefinition = "ENUM('MALE', 'FEMALE', 'OTHER')")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = true)
    private Classes classes;
}
