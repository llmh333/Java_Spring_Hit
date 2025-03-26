package com.hit.week3.service;

import com.hit.week3.entity.Student;
import com.hit.week3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public boolean addStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            return false;
        }
        else {
            studentRepository.save(student);
            return true;
        }
    }

    public boolean updateStudent(Student student) {
        Student status = studentRepository.save(student);
        return status != null;
    }

    public boolean deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
