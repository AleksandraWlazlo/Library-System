package com.libraryproject.librarysystem.dto;

import com.libraryproject.librarysystem.entity.Book;

import java.util.Set;

public record BookTypeResponseDto(
        Long bookTypeId,
        String name,
        Set<Book> books
) {
}
