package com.hit.week4.dto.response;


import com.hit.week4.model.Classes;
import com.hit.week4.model.Gender;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentResponse {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String birthDay;
    private Gender gender;
    private Classes classes;
}
