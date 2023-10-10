package com.libraryproject.librarysystem.mapper;

import com.libraryproject.librarysystem.entity.Book;
import com.libraryproject.librarysystem.dto.BookResponseDto;
import com.libraryproject.librarysystem.entity.BookType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "bookTypes", expression = "java(mapBookTypesToStringList(book.getBookTypes()))")
    BookResponseDto mapBookToBookResponseDto(Book book);

    List<BookResponseDto> mapBooksToBookResponseDtos(List<Book> books);

    default List<String> mapBookTypesToStringList(Set<BookType> bookTypes) {
        return bookTypes.stream()
                .map(BookType::getName)
                .collect(Collectors.toList());
    }
}
