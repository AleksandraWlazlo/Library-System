package com.libraryproject.librarysystem.book;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
   Page<Book> findAllBooksWithPagination(int pageNumber);

   List<Book> findAllBooks();
}
