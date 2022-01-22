package pjwstk.robbrzr.library;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pjwstk.robbrzr.library.model.Book;
import pjwstk.robbrzr.library.repository.BookRepository;
import pjwstk.robbrzr.library.service.BookService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    void shouldfindAll() {
        //Given
        Book book = new Book("Mitologia","Autorek");
        when(bookRepository.findAll()).thenReturn(List.of());
        //When
        List<Book> all = bookService.findAll();
        //Then
        assertThat(all).isEmpty();
    }
    @Test
    void shouldSaveBook(){
        //Given
        Book book = new Book("Mitologia", "Autorek");
        when(bookRepository.save(book)).thenReturn(new Book(1L,"Mitologia", "Autorek"));
        //When
        Book book1 = bookService.save(book);
        //Then
        assertThat(book1.getId().equals(1L));
    }
    @Test
    void deleteById() {
        //Given
        Book book = new Book(2L,"Mitologia", "Autorek");
        //When
        bookService.deleteById(2L);
        //Then
        verify(bookRepository, times(1)).deleteById(2L);
    }
}

