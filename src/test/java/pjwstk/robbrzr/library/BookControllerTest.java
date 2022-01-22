package pjwstk.robbrzr.library;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.model.User;
import pjwstk.robbrzr.library.service.BookService;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Test
    void shouldPrintHelloWorld() throws Exception {
        mockMvc.perform(get("/book/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }
    @Test
    void shouldFindAll() throws Exception {
        Book book = bookService.save(new Book(1L,"Mitologia","Autorek",1000,"","",1L));
        mockMvc.perform(get("/book/findall"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldFindById() throws Exception{
        Book book = bookService.save(new Book(1L,"Mitologia","Autorek",1000,"","",1L));
        mockMvc.perform(get("/book/find/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"Mitologia\",\"author\":\"Autorek\",\"year\":1000,\"loanDate\":\"\",\"endLoanDate\":\"\",\"user\":1}")));
    }
    @Test
    void shouldDeleteById() throws Exception{
        Book book = bookService.save(new Book("Mitologia","Autorek"));

        mockMvc.perform(delete("/book/delete/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldFindByName() throws Exception{
        Book book = bookService.save(new Book(1L,"Mitologia","Autorek",1000,"12-03-2022","12-03-2022",1L));
        mockMvc.perform(get("/book/findbyname/Mitologia"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void shouldDeleteAll()throws Exception{
        Book book = bookService.save(new Book(1L,"Mitologia","Autorek",1000,"12-03-2022","12-03-2022",1L));
        mockMvc.perform(delete("/book/deleteall"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
