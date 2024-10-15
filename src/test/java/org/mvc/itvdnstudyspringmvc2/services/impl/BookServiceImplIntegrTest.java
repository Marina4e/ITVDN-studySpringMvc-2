package org.mvc.itvdnstudyspringmvc2.services.impl;


import org.junit.jupiter.api.Test;
import org.mvc.itvdnstudyspringmvc2.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplIntegrTest {

    @Autowired
    BookService bookService;

    @Test
    void getAllBooks_success() {
        var result = bookService.getBooks();
        assertEquals(4, result.size());
    }

}