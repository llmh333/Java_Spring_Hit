package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.CategoryResponseDTO;
import com.hit.example.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO ToCategoryResponseDTO(Category category);
    Category ToCategory(CreateCategoryRequest createCategoryRequest);
}
