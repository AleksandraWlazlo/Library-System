package com.libraryproject.librarysystem.mapper;

import com.libraryproject.librarysystem.dto.AuthorRequestDto;
import com.libraryproject.librarysystem.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author mapAuthorRequestDtoToAuthor(AuthorRequestDto authorRequestDto);
}
