package org.mvc.itvdnstudyspringmvc2.repository;

import org.junit.jupiter.api.Test;
import org.mvc.itvdnstudyspringmvc2.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testSave() {
        var book = new Book();
        book.setId(5L);
        book.setName("Book 5");

        var savedBook = bookRepository.save(book);

        var retrievedBook = bookRepository.findById(savedBook.getId());

        assertTrue(retrievedBook.isPresent());
        assertEquals("Book 5", retrievedBook.get().getName());
    }

}