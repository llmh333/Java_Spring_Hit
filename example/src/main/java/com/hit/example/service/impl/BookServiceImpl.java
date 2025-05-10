package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.BookResponseDTO;
import com.hit.example.domain.entity.Author;
import com.hit.example.domain.entity.Book;
import com.hit.example.domain.mapper.BookMapper;
import com.hit.example.exception.DuplicateException;
import com.hit.example.exception.NotFoundException;
import com.hit.example.respository.AuthorRepository;
import com.hit.example.respository.BookRepository;
import com.hit.example.respository.CategoryRepository;
import com.hit.example.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    BookMapper bookMapper;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> bookResponseDTOS = new ArrayList<>();
        for (Book book : books) {
            bookResponseDTOS.add(bookMapper.toBookResponseDTO(book));
        }
        return bookResponseDTOS;
    }

    @Override
    public BookResponseDTO addBook(CreateBookRequest createBookRequest) {
        Book book = bookMapper.toBook(createBookRequest);
        if (bookRepository.existsByName(createBookRequest.getName())) {
            throw new DuplicateException(ErrorCode.BOOK_ALREADY_EXIST);
        }
        if (createBookRequest.getAuthorId() != null) {
            if (authorRepository.existsById(createBookRequest.getAuthorId())) {
                throw new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND);
            }
        }
        if (createBookRequest.getCategoryId() != null) {
            if (categoryRepository.existsById(createBookRequest.getCategoryId())) {
                throw new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND);
            }
        }
        return bookMapper.toBookResponseDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO updateBook(Long idBook, UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new NotFoundException(ErrorCode.BOOK_NOT_FOUND));
        if (updateBookRequest.getName() != null) {
            if (bookRepository.existsByName(updateBookRequest.getName())) {
                book.setName(updateBookRequest.getName());
            } else {
                throw new DuplicateException(ErrorCode.BOOK_NAME_ALREADY_EXISTS);
            }

        }
        if (updateBookRequest.getAuthorId() != null) {
            if (authorRepository.existsById(updateBookRequest.getAuthorId())) {
                book.setAuthor(authorRepository.findById(updateBookRequest.getAuthorId()).orElseThrow(() -> new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND)));
                System.out.println(authorRepository.findById(updateBookRequest.getAuthorId()));
            }
        }
        if (updateBookRequest.getCategoryId() != null) {
            if (categoryRepository.existsById(updateBookRequest.getCategoryId())) {
                book.setCategory(categoryRepository.findById(updateBookRequest.getCategoryId()).orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND)));
            }
        }
        if (updateBookRequest.getDescription() != null) {
            book.setDescription(updateBookRequest.getDescription());
        }
        if (updateBookRequest.getPrice() > 0) {
            book.setPrice(updateBookRequest.getPrice());
        }
        return bookMapper.toBookResponseDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBookById(Long idBook) {
        if (bookRepository.existsById(idBook)) {
            bookRepository.deleteById(idBook);
        } else {
            throw new NotFoundException(ErrorCode.BOOK_NOT_FOUND);
        }
    }
}
