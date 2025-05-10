package com.hit.example.domain.dto.request.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateBookRequest {

    @NotBlank
    String name;
    String description;
    double price;
    Long authorId;
    Long categoryId;
}
