package com.libraryproject.librarysystem.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String firstName;
    private String lastName;
    private String biography;
    @OneToMany(mappedBy = "bookAuthor")
    private List<Book> listOfBooks;
}
