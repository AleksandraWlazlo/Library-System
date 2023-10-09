package com.libraryproject.librarysystem.dto;

import com.libraryproject.librarysystem.entity.Author;
import com.libraryproject.librarysystem.entity.BookType;

import java.util.Set;

public record BookResponseDto(
        Long bookId,
        String title,
        Author bookAuthor,
        Set<BookType> bookType,
        String description,
        int numberOfPages,
        String publishingHouse
) {
}
