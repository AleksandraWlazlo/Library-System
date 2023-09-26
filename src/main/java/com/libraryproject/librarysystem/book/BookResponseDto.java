package com.libraryproject.librarysystem.book;

import com.libraryproject.librarysystem.author.Author;
import com.libraryproject.librarysystem.booktype.BookType;

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
