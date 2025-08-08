package com.bugra.kitaptakipapi;
import com.bugra.kitaptakipapi.model.Book;
import com.bugra.kitaptakipapi.model.User;
import com.bugra.kitaptakipapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.bugra.kitaptakipapi.repository.BookRepository;
import com.bugra.kitaptakipapi.repository.UserRepository;
import org.springframework.security.core.Authentication;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book, Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        book.setUser(user);
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        return ResponseEntity.ok(bookRepository.findByUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book bookDetails, Authentication authentication) {
        String username = authentication.getName();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) return ResponseEntity.notFound().build();

        Book book = optionalBook.get();
        if (!book.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(403).body("Bu kitabı güncelleme yetkiniz yok.");
        }

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id, Authentication authentication) {
        String username = authentication.getName();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) return ResponseEntity.notFound().build();

        Book book = optionalBook.get();
        if (!book.getUser().getUsername().equals(username)) {
            return ResponseEntity.status(403).body("Bu kitabı silme yetkiniz yok.");
        }

        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
