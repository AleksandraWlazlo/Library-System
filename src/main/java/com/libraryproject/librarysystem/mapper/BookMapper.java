package com.libraryproject.librarysystem.mapper;

import com.libraryproject.librarysystem.entity.Book;
import com.libraryproject.librarysystem.dto.BookResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto mapBookToBookResponseDto(Book book);
}
