package pjwstk.robbrzr.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pjwstk.robbrzr.library.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    @Query("SELECT p from Book p where p.name = :name")
    Optional<List<Book>> getBookByName(String name);

    @Query("SELECT p from Book p where p.author = :author")
    Optional<List<Book>> getBookByAuthor(String author);

    @Query("SELECT p from Book p where p.year = :year")
    Optional<List<Book>> getBookByYear(Integer year);


}
