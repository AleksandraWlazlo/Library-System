package com.libraryproject.librarysystem.entity;

import jakarta.persistence.*;
import lombok.*;

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
