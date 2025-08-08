package com.bugra.kitaptakipapi.repository;

import com.bugra.kitaptakipapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.bugra.kitaptakipapi.model.User;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}
