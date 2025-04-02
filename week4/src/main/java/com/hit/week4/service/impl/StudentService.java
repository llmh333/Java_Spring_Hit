package com.hit.week4.service.impl;

import com.hit.week4.dto.request.StudentRequest;
import com.hit.week4.dto.response.StudentResponse;
import com.hit.week4.model.Classes;
import com.hit.week4.model.Student;
import com.hit.week4.repository.ClassesRepository;
import com.hit.week4.repository.StudentRepository;
import com.hit.week4.service.IStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudent {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentsResponses = new ArrayList<>();
        students.forEach(student -> {
            StudentResponse studentResponse = convertStudentToStudentResponse(student);
            studentsResponses.add(studentResponse);
        });
        return studentsResponses;
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new DataIntegrityViolationException("Student not found");
        }
        return convertStudentToStudentResponse(student);
    }

    @Override
    public List<StudentResponse> getStudentsByName(String fullName) {
        List<Student> students = studentRepository.findStudentsByFullName(fullName);
        if (!students.isEmpty()) {
            List<StudentResponse> studentResponses = new ArrayList<>();
            students.forEach(student -> {
                StudentResponse studentResponse = convertStudentToStudentResponse(student);
                studentResponses.add(studentResponse);
            });
            return studentResponses;
        }
        return null;
    }

    @Override
    public List<StudentResponse> getStudentsByClasses(Classes classes) {
        return List.of();
    }

    @Override
    public StudentResponse addStudent(Student student, String classesName) {
        Classes classes = classesRepository.findClassesByName(classesName);
        if (classes != null) {
            if (studentRepository.existsStudentByEmail(student.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
            if (studentRepository.existsStudentByPhone(student.getPhone())) {
                throw new IllegalArgumentException("Phone already exists");
            }
            student.setClasses(classes);
            return convertStudentToStudentResponse(studentRepository.save(student));
        }
        else {
            throw new DataIntegrityViolationException("The class does not exist");
        }
    }

    @Override
    public StudentResponse updateStudent(Student student, Integer id) {
        Student currentStudent = studentRepository.findStudentById(id);
        if (currentStudent == null) {
            throw new DataIntegrityViolationException("Student not found");
        }
        if (student.getEmail() != null) {
            currentStudent.setEmail(student.getEmail());
        }
        if (student.getPhone() != null) {
            currentStudent.setPhone(student.getPhone());

        }
        if (student.getClasses() != null) {
            currentStudent.setClasses(student.getClasses());
        }
        if (student.getFullName() != null) {
            currentStudent.setFullName(student.getFullName());
        }
        if (student.getGender() != null) {
            currentStudent.setGender(student.getGender());
        }
        if (student.getBirthDay() != null) {
            currentStudent.setBirthDay(student.getBirthDay());
        }
        StudentResponse studentResponse = addStudent(currentStudent, currentStudent.getClasses().getName());
        return studentResponse;
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        if (!studentRepository.existsById(idStudent)) {
            throw new DataIntegrityViolationException("The student does not exist");
        }
        studentRepository.deleteById(idStudent);
        return true;
    }

    @Override
    public StudentResponse convertStudentToStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .email(student.getEmail())
                .birthDay(student.getBirthDay())
                .phone(student.getPhone())
                .gender(student.getGender())
                .classes(student.getClasses())
                .build();
    }


}
