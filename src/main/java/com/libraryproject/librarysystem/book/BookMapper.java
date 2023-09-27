package com.libraryproject.librarysystem.book;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto mapBookToBookResponseDto(Book book);
}
