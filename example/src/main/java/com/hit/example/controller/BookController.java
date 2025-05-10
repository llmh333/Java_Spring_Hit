package com.hit.example.controller;

import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.BookResponseDTO;
import com.hit.example.service.BookService;
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
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBooks() {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ApiResponseUtil.success(books, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        BookResponseDTO bookResponseDTO= bookService.addBook(createBookRequest);
        return ApiResponseUtil.success(bookResponseDTO, HttpStatus.CREATED);

    }

    @PutMapping("/update/{idBook}")
    public ResponseEntity<?> updateBook(@PathVariable Long idBook, @RequestBody @Valid UpdateBookRequest updateBookRequest) {
        BookResponseDTO bookResponseDTO= bookService.updateBook(idBook, updateBookRequest);
        return ApiResponseUtil.success(bookResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idBook}")
    public ResponseEntity<?> deleteBook(@PathVariable Long idBook) {
        bookService.deleteBookById(idBook);
        return ApiResponseUtil.success(null, HttpStatus.NO_CONTENT);
    }

}
