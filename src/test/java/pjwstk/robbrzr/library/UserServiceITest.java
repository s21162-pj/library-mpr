package pjwstk.robbrzr.library;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.repository.UserRepository;
import pjwstk.robbrzr.library.service.BookService;
import pjwstk.robbrzr.library.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceITest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private BookService bookService;


    @Test
    void shouldFindAll(){
        //Given
        userService.save(new User("Jacek","Testowy"));
        when(userRepository.findAll()).thenReturn(List.of());
        //When
        List<User> all = userService.findAll();
        //Then
        assertThat(all).isEmpty();
    }
    @Test
    void shouldSaveUser(){
        //Given
        User user = new User("Jacek", "Testowy");
        when(userRepository.save(user)).thenReturn(new User(1L,"Jacek", "Testowy"));
        //When
        User user1 = userService.save(user);
        //Then
        assertThat(user1.getId().equals(1L));
    }
    @Test
    public void shouldRetriveUserFromRepository() throws Exception {
        User user = new User(1L,"Jacek", "Testowy");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertTrue(userService.findById(1L).getName().contains("Jacek"));
    }
 //   @Test
 //   void shouldAddBook() throws RuntimeException {
 //       User user = userService.save(new User(1L,"Jacek", "Testowy"));
 //       Book book = bookService.save(new Book(1L,"Mitologia", "Autorek"));
 //       userService.addBook(user.getId(),book.getId());
 //      assertThat(!userService.findById(user.getId()).getBooks().isEmpty());
    //  }

}
