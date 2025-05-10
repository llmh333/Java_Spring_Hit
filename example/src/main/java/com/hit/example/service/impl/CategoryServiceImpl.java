package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.CategoryResponseDTO;
import com.hit.example.domain.entity.Category;
import com.hit.example.domain.mapper.CategoryMapper;
import com.hit.example.exception.NotFoundException;
import com.hit.example.respository.CategoryRepository;
import com.hit.example.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoriesResponseDTO = new ArrayList<>();
        for (Category category : categories) {
            categoriesResponseDTO.add(categoryMapper.ToCategoryResponseDTO(category));
        }
        return categoriesResponseDTO;
    }

    @Override
    public CategoryResponseDTO addCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = categoryMapper.ToCategory(createCategoryRequest);
        return categoryMapper.ToCategoryResponseDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(Long idCategory) {
        if (categoryRepository.existsById(idCategory)) {
            categoryRepository.deleteById(idCategory);
        } else {
            throw new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }
}
