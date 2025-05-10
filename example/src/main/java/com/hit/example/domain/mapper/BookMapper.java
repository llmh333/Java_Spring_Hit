package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.BookResponseDTO;
import com.hit.example.domain.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDTO toBookResponseDTO(Book book);
    Book toBook(CreateBookRequest createBookRequest);
    Book toBook(UpdateBookRequest updateBookRequest);

}
