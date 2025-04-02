package com.hit.week4.dto.request;

import com.hit.week4.model.Classes;
import com.hit.week4.model.Gender;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentRequest {
    private int id;
    private String fullName;
    private String birthDay;
    private Gender gender;
    private String email;
    private String phone;
    private Classes classes;
}
