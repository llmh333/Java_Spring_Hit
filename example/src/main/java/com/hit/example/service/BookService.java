package com.hit.example.service;

import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.BookResponseDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> getAllBooks();
    public BookResponseDTO addBook(CreateBookRequest createBookRequest);
    public BookResponseDTO updateBook(Long idBook, UpdateBookRequest updateBookRequest);
    public void deleteBookById(Long idBook);

}
