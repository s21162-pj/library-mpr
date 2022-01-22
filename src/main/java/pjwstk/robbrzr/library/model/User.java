package pjwstk.robbrzr.library.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToMany
    private List<Book> books;



    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public User(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook (Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        return "User{" + id +
                "name='" + name + '\'' +
                "surname='" + surname + '\'' +
                "books='" + books + '\'' +
                '}';
    }
}
