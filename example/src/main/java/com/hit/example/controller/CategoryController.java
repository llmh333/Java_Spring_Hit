package com.hit.example.controller;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.CategoryResponseDTO;
import com.hit.example.service.CategoryService;
import com.hit.example.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories() {
        List<CategoryResponseDTO> categories = categoryService.getCategories();
        return ApiResponseUtil.success(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        CategoryResponseDTO categoryResponseDTO = categoryService.addCategory(createCategoryRequest);
        return ApiResponseUtil.success(categoryResponseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idCategory}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long idCategory) {
        categoryService.deleteCategoryById(idCategory);
        return ApiResponseUtil.success(null, HttpStatus.NO_CONTENT  );
    }
}
