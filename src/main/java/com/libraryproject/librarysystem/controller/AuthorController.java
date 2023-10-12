package com.libraryproject.librarysystem.controller;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.dto.AuthorResponseDto;
import com.libraryproject.librarysystem.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return ResponseEntity.ok(authorService.addAuthor(authorRequestDto));
    }

}
