package com.libraryproject.librarysystem.service.impl;

import com.libraryproject.librarysystem.dto.BookRequestDto;
import com.libraryproject.librarysystem.dto.BookResponseDto;
import com.libraryproject.librarysystem.entity.Author;
import com.libraryproject.librarysystem.entity.Book;
import com.libraryproject.librarysystem.entity.BookType;
import com.libraryproject.librarysystem.exception.AuthorNotFoundException;
import com.libraryproject.librarysystem.exception.BookNotFoundException;
import com.libraryproject.librarysystem.mapper.BookMapper;
import com.libraryproject.librarysystem.repository.AuthorRepository;
import com.libraryproject.librarysystem.repository.BookRepository;
import com.libraryproject.librarysystem.repository.BookTypeRepository;
import com.libraryproject.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final BookTypeRepository bookTypeRepository;

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

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Long authorId = bookRequestDto.authorId();
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = bookMapper.mapBookRequestDtoToBook(bookRequestDto);
        book.setBookAuthor(author);

        Set<BookType> bookTypes = prepareBookTypesForSaving(bookRequestDto);
        book.setBookTypes(bookTypes);

        Book savedBook = bookRepository.save(book);
        return bookMapper.mapBookToBookResponseDto(savedBook);
    }

    @Override
    public BookResponseDto updateBook(Long bookId, BookRequestDto bookRequestDto) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new BookNotFoundException(bookId));

        Long authorId = bookRequestDto.authorId();
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Set<BookType> bookTypes = prepareBookTypesForSaving(bookRequestDto);

        book.setBookTypes(bookTypes);
        book.setBookAuthor(author);
        book.setTitle(bookRequestDto.title());
        book.setDescription(bookRequestDto.description());
        book.setNumberOfPages(bookRequestDto.numberOfPages());
        book.setPublishingHouse(bookRequestDto.publishingHouse());

        Book savedBook = bookRepository.save(book);
        return bookMapper.mapBookToBookResponseDto(savedBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository
                .findById(bookId)
                .orElseThrow(()-> new BookNotFoundException(bookId));

        bookRepository.delete(book);
    }

    Set<BookType> prepareBookTypesForSaving(BookRequestDto bookRequestDto){
        Set<BookType> bookTypes = new HashSet<>();
        for (String bookTypeName : bookRequestDto.bookTypes()) {
            Optional<BookType> existingBookType = bookTypeRepository.findByName(bookTypeName);
            if (existingBookType.isPresent()) {
                bookTypes.add(existingBookType.get());
            } else {
                BookType newBookType = new BookType();
                newBookType.setName(bookTypeName);
                bookTypeRepository.save(newBookType);
                bookTypes.add(newBookType);
            }
        }
        return bookTypes;
    }
}
