package com.libraryproject.librarysystem.controller;

import com.libraryproject.librarysystem.dto.BookRequestDto;
import com.libraryproject.librarysystem.dto.BookResponseDto;
import com.libraryproject.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/page")
    public ResponseEntity<Page<BookResponseDto>> getAllBooks(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize){
        int pageNumber = (page != null && page >= 0) ? page : 0;
        int itemsPerPage = (pageSize != null && pageSize >= 0) ? pageSize : 10;
        return ResponseEntity.ok(bookService.findAllBooksWithPagination(pageNumber, itemsPerPage));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> addBook(@RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.addBook(bookRequestDto));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long bookId, @RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok(bookService.updateBook(bookId, bookRequestDto));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
