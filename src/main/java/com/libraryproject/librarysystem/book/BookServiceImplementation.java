package com.libraryproject.librarysystem.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
   // private final BookMapper bookMapper;
    private static final int PAGE_SIZE = 10;

    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    public BookServiceImplementation(BookRepository bookRepository, BookMapper bookMapper) {
//        this.bookRepository = bookRepository;
//        this.bookMapper = bookMapper;
//    }

    @Override
    public Page<Book> findAllBooksWithPagination(int pageNumber) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE));

        for (Book book : bookPage){
            System.out.println(book);
        }
        //return  bookPage.map(bookMapper::mapBookToBookResponseDto);
        return  bookRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE));
    }

    @Override
    public List<Book> findAllBooks() {
        return  bookRepository.findAll();
    }
}
