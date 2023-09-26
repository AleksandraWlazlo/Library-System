package com.libraryproject.librarysystem.booktype;

import com.libraryproject.librarysystem.book.Book;

import java.util.Set;

public record BookTypeResponseDto(
        Long bookTypeId,
        String name,
        Set<Book> books
) {
}
