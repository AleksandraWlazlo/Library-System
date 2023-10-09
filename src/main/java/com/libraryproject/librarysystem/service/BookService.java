package com.libraryproject.librarysystem.service;

import com.libraryproject.librarysystem.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
   Page<Book> findAllBooksWithPagination(int pageNumber);

   List<Book> findAllBooks();
}
