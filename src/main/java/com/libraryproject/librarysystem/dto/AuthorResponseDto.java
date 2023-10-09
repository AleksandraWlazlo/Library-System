package com.libraryproject.librarysystem.dto;

public record AuthorResponseDto(
        Long authorId,
        String firstName,
        String lastName
) {
}
