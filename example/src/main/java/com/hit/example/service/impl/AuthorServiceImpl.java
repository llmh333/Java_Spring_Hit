package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.AuthorResponseDTO;
import com.hit.example.domain.entity.Author;
import com.hit.example.domain.mapper.AuthorMapper;
import com.hit.example.exception.NotFoundException;
import com.hit.example.respository.AuthorRepository;
import com.hit.example.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDTO> authorsResponse = new ArrayList<AuthorResponseDTO>();
        for (Author author : authors) {
            authorsResponse.add(authorMapper.toAuthorResponseDTO(author));
        }
        return authorsResponse;
    }

    @Override
    public AuthorResponseDTO addAuthor(CreateAuthorRequest createAuthorRequest) {
        Author newAuthor = null;
        try {
            newAuthor = authorRepository.save(authorMapper.toAuthor(createAuthorRequest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorMapper.toAuthorResponseDTO(newAuthor);
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long idAuthor, UpdateAuthorRequest updateAuthorRequest) {
        Author author = authorRepository.findById(idAuthor).orElseThrow(() -> new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND));
        if (updateAuthorRequest.getName() != null) {
            author.setName(updateAuthorRequest.getName());
        }
        if (updateAuthorRequest.getBio() != null) {
            author.setBio(updateAuthorRequest.getBio());
        }
        if (updateAuthorRequest.getDob() != null) {
            author.setDob(updateAuthorRequest.getDob());
        }
        return authorMapper.toAuthorResponseDTO(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long idAuthor) {
        if (authorRepository.existsById(idAuthor)) {
            authorRepository.deleteById(idAuthor);
        } else {
            throw new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND);
        }

    }
}
