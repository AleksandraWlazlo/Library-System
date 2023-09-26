package com.libraryproject.librarysystem.book;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Page<BookResponseDto> findAllBooksWithPagination(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Page<Book> bookPage = bookRepository.findAll(pageRequest);
        return  null;
    }
}
