package pjwstk.robbrzr.library.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<List<Book>> findByName(@PathVariable String name) {
        Optional<List<Book>> books = bookService.findByName(name);
        if (books.isPresent()) {}
            return ResponseEntity.ok(books.get());
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<List<Book>> deleteAll() throws RuntimeException {
        bookService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
