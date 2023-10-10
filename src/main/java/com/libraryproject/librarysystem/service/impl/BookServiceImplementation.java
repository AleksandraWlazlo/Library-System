package com.libraryproject.librarysystem.service.impl;

import com.libraryproject.librarysystem.dto.BookResponseDto;
import com.libraryproject.librarysystem.entity.Book;
import com.libraryproject.librarysystem.mapper.BookMapper;
import com.libraryproject.librarysystem.repository.BookRepository;
import com.libraryproject.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Page<BookResponseDto> findAllBooksWithPagination(int pageNumber, int pageSize) {
        Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
        Page<BookResponseDto> resultPage = bookPage.map(bookMapper::mapBookToBookResponseDto);
        return resultPage;
    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.mapBooksToBookResponseDtos(books);
    }

}
