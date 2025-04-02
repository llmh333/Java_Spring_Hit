package com.hit.week4.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassesRequest {
    private int id;

    @NotBlank(message = "Classes name cannot be empty")
    private String name;

    @NotBlank(message = "Classes subject cannot be empty")
    private String subject;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

