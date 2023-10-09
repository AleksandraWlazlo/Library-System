package com.libraryproject.librarysystem.dto;

import com.libraryproject.librarysystem.entity.Book;

import java.util.List;

public record AuthorResponseDto(
        Long authorId,
        String firstName,
        String lastName,
        String biography,
        List<Book> listOfBooks
) {
}
