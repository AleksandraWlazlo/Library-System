package com.libraryproject.librarysystem.entity;

import com.libraryproject.librarysystem.entity.Book;
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
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookTypeId;
    private String name;
    @ManyToMany(mappedBy = "bookTypes")
    private Set<Book> books;
}
