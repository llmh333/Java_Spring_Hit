package com.hit.example.service;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.CategoryResponseDTO;
import com.hit.example.domain.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDTO> getCategories();
    CategoryResponseDTO addCategory(CreateCategoryRequest createCategoryRequest);
    public void deleteCategoryById(Long idCategory);
}
