package com.hit.week4.repository;

import com.hit.week4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);

    List<Student> findStudentsByFullName(String fullName);

    boolean existsStudentByEmail(String email);

    boolean existsStudentByPhone(String phone);
}
