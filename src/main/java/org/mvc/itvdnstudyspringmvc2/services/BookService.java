package org.mvc.itvdnstudyspringmvc2.services;

import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getBooks();

    Optional<BookDTO> getBook(Long id);

    void save(BookDTO bookDTO);

    void update(BookDTO bookDTO);

    void delete(Long id);
}
