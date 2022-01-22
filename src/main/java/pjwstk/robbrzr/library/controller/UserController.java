package pjwstk.robbrzr.library.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }
    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<List<Book>> deleteAll() throws RuntimeException {
        userService.deleteAll();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/addbook/{userId}/{bookId}")
    public ResponseEntity<User> addBook(@PathVariable Long userId, @PathVariable Long bookId){
        return ResponseEntity.ok(userService.addBook(userId, bookId));
    }

}

