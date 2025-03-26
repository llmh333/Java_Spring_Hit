package com.hit.week3.controller;

import com.hit.week3.entity.Student;
import com.hit.week3.response.ApiResponse;
import com.hit.week3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/students/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/select")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
        boolean response = studentService.addStudent(student);
        ApiResponse<Student> createStudentResponse;
        if (response) {
            createStudentResponse = new ApiResponse<>(200,"success",student);
            return ResponseEntity.ok(createStudentResponse);
        }
        else {
            createStudentResponse = new ApiResponse<>(500,"Email is existed",null);
            return ResponseEntity.badRequest().body(createStudentResponse);
        }
    }

    @PostMapping(value = "/update")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student student) {
        boolean status = studentService.updateStudent(student);
        ApiResponse<Student> updateStudentResponse;
        if (status) {
            updateStudentResponse = new ApiResponse<>(200,"success",student);
            return ResponseEntity.ok(updateStudentResponse);
        }
        else {
            updateStudentResponse = new ApiResponse<>(500,"error",null);
            return ResponseEntity.badRequest().body(updateStudentResponse);
        }
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) {
        boolean status = studentService.deleteStudent(id);
        ApiResponse<String> deleteStudentResponse;
        if (status) {
            deleteStudentResponse = new ApiResponse<>(200,"success",null);
            return ResponseEntity.ok(deleteStudentResponse);
        } else {
            deleteStudentResponse = new ApiResponse<>(500,"error",null);
            return ResponseEntity.badRequest().body(deleteStudentResponse);
        }
    }
}