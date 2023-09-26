package com.libraryproject.librarysystem.book;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    public ResponseEntity<Page<BookResponseDto>> getAllBooks(@RequestParam(required = false) int page){
        int pageNumber = page >= 0 ? page : 0;
        return ResponseEntity.ok(bookService.findAllBooksWithPagination(pageNumber));
    }
}
