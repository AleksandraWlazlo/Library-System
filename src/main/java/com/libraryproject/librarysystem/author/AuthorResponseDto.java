package com.libraryproject.librarysystem.author;

import com.libraryproject.librarysystem.book.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public record AuthorResponseDto(
        Long authorId,
        String firstName,
        String lastName,
        String biography,
        List<Book> listOfBooks
) {
}
