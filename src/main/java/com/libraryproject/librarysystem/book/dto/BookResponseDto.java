package com.libraryproject.librarysystem.book.dto;

import com.libraryproject.librarysystem.book.Author;
import com.libraryproject.librarysystem.book.BookType;

public record BookResponseDto(
        Long bookId,
        String title,
        Author bookAuthor,
        BookType bookType,
        String description,
        int numberOfPages,
        String publishingHouse
) {
}
