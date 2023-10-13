package com.libraryproject.librarysystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record BookRequestDto(
        @NotBlank
        String title,
        @Min(1)
        Long authorId,
        List<@NotBlank String> bookTypes,
        @NotBlank
        String description,
        @Min(1)
        int numberOfPages,
        @NotBlank
        String publishingHouse
) {
}
