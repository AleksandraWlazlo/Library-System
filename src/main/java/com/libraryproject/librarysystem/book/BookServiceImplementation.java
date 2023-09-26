package com.libraryproject.librarysystem.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private static final int PAGE_SIZE = 10;

    @Override
    public Page<BookResponseDto> findAllBooksWithPagination(int pageNumber) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE));
        return  null;
    }
}
