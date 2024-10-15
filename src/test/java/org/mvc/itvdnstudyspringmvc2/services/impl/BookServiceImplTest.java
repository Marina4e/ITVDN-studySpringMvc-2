package org.mvc.itvdnstudyspringmvc2.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mvc.itvdnstudyspringmvc2.model.Book;
import org.mvc.itvdnstudyspringmvc2.repository.BookRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Test
    void getBooks_success() {
        var book1 = new Book();
        book1.setId(1l);
        book1.setName("Book 1");

        var book2 = new Book();
        book2.setId(2l);
        book2.setName("Book 2");

        var books = List.of(book1, book2);

        when(bookRepository.findAll()).thenReturn(books);
        var result = bookServiceImpl.getBooks();
        verify(bookRepository, times(1)).findAll();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Book 2", result.get(1).getName());
    }
}