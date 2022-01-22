package pjwstk.robbrzr.library.service;


import org.springframework.stereotype.Service;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.repository.BookRepository;
import pjwstk.robbrzr.library.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserService(UserRepository userRepository, BookRepository bookRepository){
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }



    public Optional<List<User>> findByName(String name) {
        return userRepository.getUserByName(name);
    }


    public User findById(Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        Optional<User> byId = userRepository.findById(user.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException();
        } else {
            return userRepository.save(user);
        }
    }
    public void deleteAll(){
        userRepository.deleteAll();
    }

    public User addBook(Long userId, Long bookId) throws RuntimeException {

            User byId = userRepository.findById(userId).get();
            Book book = bookRepository.findById(bookId).get();
            byId.addBook(book);
            book.setUser(userId);
            book.setLoanDate(java.time.LocalDate.now().toString());
            book.setEndLoanDate(java.time.LocalDate.now().plusMonths(3).toString());
            return update(byId);
        }
    }



