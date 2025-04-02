package com.hit.week4.controller;

import com.hit.week4.dto.response.StudentResponse;
import com.hit.week4.model.Student;
import com.hit.week4.response.ApiResponse;
import com.hit.week4.service.impl.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents() {
        List<StudentResponse> studentResponses = studentService.getAllStudents();
        if (!studentResponses.isEmpty()) {
            ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>(200,"Get All Students successfully", studentResponses);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(@PathVariable int id) {
        StudentResponse studentResponse = studentService.getStudentById(id);
        if (studentResponse != null) {
            ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(200,"Get Student Successfully", studentResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create/{className}")
    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody Student student, @PathVariable String className) {
        StudentResponse studentResponse = studentService.addStudent(student, className);
        if (studentResponse != null) {
            ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(201,"Create Student", studentResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable int id, @RequestBody Student student) {
        StudentResponse studentResponse = studentService.updateStudent(student, id);
        if (studentResponse != null) {
            ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(200,"Update Student successfully", studentResponse);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> deleteStudent(@PathVariable int id) {
        boolean checkResponse = studentService.deleteStudent(id);
        if (checkResponse) {
            ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(200,"Delete Student successfully",null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
