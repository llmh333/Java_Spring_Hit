package com.hit.week4.service;

import com.hit.week4.dto.request.ClassesRequest;
import com.hit.week4.dto.request.StudentRequest;
import com.hit.week4.dto.response.StudentResponse;
import com.hit.week4.model.Classes;
import com.hit.week4.model.Student;
import java.util.List;

public interface IStudent {

    public List<StudentResponse> getAllStudents();

    public StudentResponse getStudentById(Integer id);

    public List<StudentResponse> getStudentsByName(String fullName);

    public List<StudentResponse> getStudentsByClasses(Classes classes);

    public StudentResponse addStudent(Student student, String classesName);

    public StudentResponse updateStudent(Student student, Integer id);

    public boolean deleteStudent(int idStudent);

    public StudentResponse convertStudentToStudentResponse(Student student);

}
