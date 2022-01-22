package pjwstk.robbrzr.library.service;


import org.springframework.stereotype.Service;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElse(null);
    }

    public Book save(Book book){ return bookRepository.save(book); }

    public Optional<List<Book>> findByName(String name) {
        return bookRepository.getBookByName(name);
    }

    public Optional<List<Book>> findByAuthor(String author) {
        return bookRepository.getBookByAuthor(author);
    }

    public Optional<List<Book>> findByYear(Integer year){
        return bookRepository.getBookByYear(year);
    }

    public Book update(Book book){
        Optional<Book> byId = bookRepository.findById(book.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException();
        } else {
            return bookRepository.save(book);
        }
    }

    public void deleteById(Long id){
        if (bookRepository.findById(id).get().getUser() != null){
            throw new RuntimeException();
        }
        bookRepository.deleteById(id);
    }

    public void deleteAll(){
        bookRepository.deleteAll();
    }


}

