package com.libraryproject.librarysystem.dto;

import java.util.Set;

public record BookTypeResponseDto(
        Long bookTypeId,
        String name,
        Set<BookResponseDto> books
) {
}
