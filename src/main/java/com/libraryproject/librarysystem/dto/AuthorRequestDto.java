package com.libraryproject.librarysystem.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequestDto (
        @NotBlank
        String firstName,
        @NotBlank
        String lastName
) {
}
