package com.libraryproject.librarysystem.service;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.dto.AuthorResponseDto;

public interface AuthorService {
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    AuthorResponseDto updateAuthor(AuthorRequestDto authorRequestDto, Long authorId);
}
