package com.libraryproject.librarysystem.book;

import jakarta.persistence.*;
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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author bookAuthor;
    @ManyToMany
    @JoinTable(
            name = "book_booktype",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "book_type_id")
    )
    private Set<BookType> bookTypes;
    private String description;
    private int numberOfPages;
    private String publishingHouse;

}
