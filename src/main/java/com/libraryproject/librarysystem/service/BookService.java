package com.libraryproject.librarysystem.service;

import com.libraryproject.librarysystem.dto.BookRequestDto;
import com.libraryproject.librarysystem.dto.BookResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
   Page<BookResponseDto> findAllBooksWithPagination(int pageNumber, int pageSize);

   List<BookResponseDto> findAllBooks();

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    BookResponseDto updateBook(Long bookId, BookRequestDto bookRequestDto);

    void deleteBook(Long bookId);
}
