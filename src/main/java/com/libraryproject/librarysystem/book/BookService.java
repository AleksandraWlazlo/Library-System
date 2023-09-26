package com.libraryproject.librarysystem.book;

import org.springframework.data.domain.Page;

public interface BookService {
    Page<BookResponseDto> findAllBooksWithPagination(int pageNumber, int pageSize);
}
