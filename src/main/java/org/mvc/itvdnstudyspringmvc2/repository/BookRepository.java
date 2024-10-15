package org.mvc.itvdnstudyspringmvc2.repository;

import org.mvc.itvdnstudyspringmvc2.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByName(String name);
}
