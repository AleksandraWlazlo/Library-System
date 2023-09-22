package com.libraryproject.librarysystem.book;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookType {
    private Long bookTypeId;
    private String name;
    @ManyToMany(mappedBy = "bookTypes")

    private Set<Book> books;
}
