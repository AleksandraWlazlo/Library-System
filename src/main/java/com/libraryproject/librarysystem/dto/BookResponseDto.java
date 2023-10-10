package com.libraryproject.librarysystem.dto;

import java.util.List;
public record BookResponseDto(
        Long bookId,
        String title,
        AuthorResponseDto bookAuthor,
        List<String> bookTypes,
        String description,
        int numberOfPages,
        String publishingHouse
) {
}
