package com.hit.week4.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "subject", nullable = false, columnDefinition = "varchar(50)")
    private String subject;
}
