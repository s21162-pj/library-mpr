package pjwstk.robbrzr.library;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.service.BookService;
import pjwstk.robbrzr.library.service.UserService;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Test
    void shouldPrintHelloWorld() throws Exception {
        mockMvc.perform(get("/user/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    void shouldFindById() throws Exception{
        User user = userService.save(new User(1L,"Kamil","Nowak"));
        User user2 = userService.save(new User(2L,"Robert","Kowalski"));
        mockMvc.perform(get("/user/find/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":2,\"name\":\"Robert\",\"surname\":\"Kowalski\",\"books\":[]}")));
    }
    @Test
    void shouldFindAll() throws Exception {
        User user = userService.save(new User(1L,"Kamil","Nowak"));
        User user2 = userService.save(new User(2L,"Robert","Kowalski"));
        mockMvc.perform(get("/user/findall"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldDeleteAll()throws Exception{
        User user = userService.save(new User(1L,"Kamil","Nowak"));
        User user2 = userService.save(new User(2L,"Robert","Kowalski"));
        mockMvc.perform(delete("/user/deleteall"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldAddBook()throws Exception{
        User user = userService.save(new User(1L,"Kamil","Nowak"));
        User user2 = userService.save(new User(2L,"Robert","Kowalski"));
        Book book = bookService.save(new Book(1L,"Mitologia","Autorek"));
        Book book2 = bookService.save(new Book(2L,"Dzialaj","Plz"));
        mockMvc.perform(get("/user/addbook/1/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"Kamil\",\"surname\":\"Nowak\",\"books\":[{\"id\":1,\"name\":\"Mitologia\",\"author\":\"Autorek\",\"year\":0,\"loanDate\":\"2022-01-22\",\"endLoanDate\":\"2022-04-22\",\"user\":1}]}")));

    }
}
