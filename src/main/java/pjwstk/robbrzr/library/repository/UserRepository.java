package pjwstk.robbrzr.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT p from User p where p.name = :name")
    Optional<List<User>> getUserByName(String name);


}
