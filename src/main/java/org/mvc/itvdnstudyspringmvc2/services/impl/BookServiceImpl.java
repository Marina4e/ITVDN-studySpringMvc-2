package org.mvc.itvdnstudyspringmvc2.services.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.mvc.itvdnstudyspringmvc2.mapper.BookMapper;
import org.mvc.itvdnstudyspringmvc2.repository.BookRepository;
import org.mvc.itvdnstudyspringmvc2.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> getBooks() {
        var books = IterableUtils.toList(bookRepository.findAll());
        return books.stream()
                .map(BookMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    public Optional<BookDTO> getBook(Long id) {
        var book = bookRepository.findById(id);
        return book.map(BookMapper.INSTANCE::toDto);
    }

    @Override
    public void save(BookDTO bookDTO) {
        bookRepository.save(BookMapper.INSTANCE.toModel(bookDTO));
    }

    @Override
    public void update(BookDTO bookDTO) {
        if (bookRepository.findById(bookDTO.getId()).isPresent()) {
            bookRepository.save(BookMapper.INSTANCE.toModel(bookDTO));
        }
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
