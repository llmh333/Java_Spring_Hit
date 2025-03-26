package com.hit.week3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(50)")
    String name;

    @Column(unique = true, columnDefinition = "varchar(150)")
    String email;

    @Column(columnDefinition = "varchar(15)", name = "phone_number")
    String phone;

    @Column(columnDefinition = "text", name = "home_address")
    String address;
}
