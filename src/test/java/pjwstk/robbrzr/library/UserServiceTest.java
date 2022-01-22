package pjwstk.robbrzr.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.repository.BookRepository;
import pjwstk.robbrzr.library.repository.UserRepository;
import pjwstk.robbrzr.library.service.UserService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private BookRepository bookRepository;

    User user;
    Book book;

    @Test
    void shouldfindAll() {
        //Given
        when(userRepository.findAll()).thenReturn(List.of());
        //When
        List<User> all = userService.findAll();
        //Then
        assertThat(all).isEmpty();
    }
    @Test
    void save(){
        //Given
        User user = new User("Kamil", "Nowak");
        when(userRepository.save(user)).thenReturn(new User(1L,"Kamil", "Nowak"));
        //When
        User user2 = userService.save(user);
        //Then
        assertThat(user2.getId().equals(1L));
    }

}