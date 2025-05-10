package com.hit.example.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hit.example.domain.entity.Author;
import com.hit.example.domain.entity.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {
    String name;
    String description;
    Author author;
    Category category;
    double price;
}
