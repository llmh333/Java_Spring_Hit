package com.hit.example.controller;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.AuthorResponseDTO;
import com.hit.example.domain.entity.Author;
import com.hit.example.respository.AuthorRepository;
import com.hit.example.service.AuthorService;
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
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {

    AuthorService authorService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAuthors() {
        List<AuthorResponseDTO> authors = authorService.getAllAuthors();
        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ApiResponseUtil.success(authors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        AuthorResponseDTO newAuthor = authorService.addAuthor(request);
        return ApiResponseUtil.success(newAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idAuthor}")
    public ResponseEntity<?> upadteAuthor(@PathVariable long idAuthor, @RequestBody @Valid UpdateAuthorRequest request) {
        AuthorResponseDTO updatedAuthor = authorService.updateAuthor(idAuthor, request);
        return ApiResponseUtil.success(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idAuthor}")
    public ResponseEntity<?> deleteAuthor(@PathVariable long idAuthor) {
        authorService.deleteAuthor(idAuthor);
        return ApiResponseUtil.success(null, HttpStatus.NO_CONTENT);
    }
}
