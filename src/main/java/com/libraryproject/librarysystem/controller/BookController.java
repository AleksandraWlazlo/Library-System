package com.libraryproject.librarysystem.controller;

import com.libraryproject.librarysystem.dto.BookResponseDto;
import com.libraryproject.librarysystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
