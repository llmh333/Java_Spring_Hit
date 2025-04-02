package com.hit.week4.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassesResponse {
    private int id;
    private String name;
    private String subject;
}