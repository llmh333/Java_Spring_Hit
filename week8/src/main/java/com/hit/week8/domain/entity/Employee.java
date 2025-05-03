package com.hit.week8.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(columnDefinition = "DATE")
    Date dateOfBirth;

    @Column(columnDefinition = "DATE")
    Date hireDate;

    @Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
    BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE"))
    User user;

    @ManyToOne
    @JoinColumn(name = "position_id", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (position_id) REFERENCES positions(id) ON DELETE CASCADE"))
    Position position;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE"))
    Department department;
}
