package com.bugra.kitaptakipapi.repository;

import com.bugra.kitaptakipapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
