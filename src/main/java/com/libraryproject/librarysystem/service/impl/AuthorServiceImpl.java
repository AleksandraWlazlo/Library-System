package com.libraryproject.librarysystem.service.impl;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.dto.AuthorResponseDto;
import com.libraryproject.librarysystem.entity.Author;
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
}
