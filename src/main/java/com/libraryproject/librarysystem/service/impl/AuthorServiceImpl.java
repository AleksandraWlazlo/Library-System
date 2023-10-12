package com.libraryproject.librarysystem.service.impl;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.dto.AuthorResponseDto;
import com.libraryproject.librarysystem.entity.Author;
import com.libraryproject.librarysystem.exception.AuthorNotFoundException;
import com.libraryproject.librarysystem.mapper.AuthorMapper;
import com.libraryproject.librarysystem.repository.AuthorRepository;
import com.libraryproject.librarysystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author authorFromDto = authorMapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
        Author author = authorRepository.save(authorFromDto);
        return authorMapper.mapAuthorToAuthorResponseDto(author);
    }

    @Override
    public AuthorResponseDto updateAuthor(AuthorRequestDto authorRequestDto, Long authorId) {
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        author.setFirstName(authorRequestDto.firstName());
        author.setLastName(authorRequestDto.lastName());

        Author savedAuthor = authorRepository.save(author);
        return authorMapper.mapAuthorToAuthorResponseDto(savedAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        authorRepository.delete(author);
    }
}
