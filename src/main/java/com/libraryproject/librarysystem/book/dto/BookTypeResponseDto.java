package com.libraryproject.librarysystem.book.dto;

import com.libraryproject.librarysystem.book.Book;

import java.util.Set;

public record BookTypeResponseDto(
        Long bookTypeId,
        String name,
        Set<Book> books
) {
}
