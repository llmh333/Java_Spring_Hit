package com.hit.example.domain.dto.request.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hit.example.domain.entity.Author;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBookRequest {
    @NotBlank
    String name;
    String description;
    double price;
    Long authorId;
    Long categoryId;

}
