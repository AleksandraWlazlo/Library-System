package com.libraryproject.librarysystem.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long authorId){
        super ("Author with id: '" + authorId + "' not found.");
    }
}
