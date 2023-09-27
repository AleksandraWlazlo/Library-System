package com.libraryproject.librarysystem.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping
//    public ResponseEntity<Page<Book>> getAllBooks(@RequestParam(required = false) Integer page){
//        int pageNumber = (page != null && page >= 0) ? page : 0;
//        return ResponseEntity.ok(bookService.findAllBooksWithPagination(pageNumber));
//    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }
}
