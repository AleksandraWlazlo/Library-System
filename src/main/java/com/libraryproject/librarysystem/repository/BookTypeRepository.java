package com.libraryproject.librarysystem.repository;

import com.libraryproject.librarysystem.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
}
