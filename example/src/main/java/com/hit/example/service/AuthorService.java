package com.hit.example.service;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.AuthorResponseDTO;
import com.hit.example.domain.dto.response.BookResponseDTO;
import com.hit.example.domain.entity.Author;

import java.util.List;

public interface AuthorService {

    public List<AuthorResponseDTO> getAllAuthors();
    public AuthorResponseDTO addAuthor(CreateAuthorRequest createAuthorRequest);
    public AuthorResponseDTO updateAuthor(Long idAuthor, UpdateAuthorRequest updateAuthorRequest);
    public void deleteAuthor(Long idAuthor);
}
