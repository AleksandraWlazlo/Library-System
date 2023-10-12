package com.libraryproject.librarysystem.controller;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.dto.AuthorResponseDto;
import com.libraryproject.librarysystem.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@Valid @RequestBody AuthorRequestDto authorRequestDto){
        return ResponseEntity.ok(authorService.addAuthor(authorRequestDto));
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@PathVariable Long authorId, @Valid @RequestBody AuthorRequestDto authorRequestDto){
        return ResponseEntity.ok(authorService.updateAuthor(authorRequestDto, authorId));
    }

}
