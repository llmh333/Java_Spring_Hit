package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.AuthorResponseDTO;
import com.hit.example.domain.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponseDTO toAuthorResponseDTO(Author author);
    Author toAuthor(CreateAuthorRequest createAuthorRequest);
    Author toAuthor(UpdateAuthorRequest updateAuthorRequest);
}
