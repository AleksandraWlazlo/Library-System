package com.libraryproject.librarysystem.book;

import com.libraryproject.librarysystem.author.Author;
import com.libraryproject.librarysystem.booktype.BookType;

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
