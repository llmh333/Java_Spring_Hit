package com.hit.week4.controller;


import com.hit.week4.dto.request.ClassesRequest;
import com.hit.week4.model.Classes;
import com.hit.week4.response.ApiResponse;
import com.hit.week4.service.impl.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Classes>> addClasses(@RequestBody ClassesRequest classesRequest) {
        Classes classes = Classes.builder()
                .name(classesRequest.getName())
                .subject(classesRequest.getSubject())
                .build();
        classesService.addClass(classes);
        ApiResponse<Classes> apiResponse = new ApiResponse<>(201,"Add Classes successfully",classes);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Classes>> deleteClass(@PathVariable int id) {
        boolean checkResponse = classesService.removeClassesById(id);
        if (checkResponse) {
            ApiResponse<Classes> apiResponse = new ApiResponse<>(200,"Delete Class successfully",null);
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);

        }
        else {
            ApiResponse<Classes> apiResponse = new ApiResponse<>(404,"Delete Class not found",null);
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }
    }


}
