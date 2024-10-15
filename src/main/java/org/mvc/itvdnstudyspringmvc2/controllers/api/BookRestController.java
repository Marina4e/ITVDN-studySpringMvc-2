package org.mvc.itvdnstudyspringmvc2.controllers.api;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.mvc.itvdnstudyspringmvc2.services.BookService;
import org.mvc.itvdnstudyspringmvc2.validation.BookCreate;
import org.mvc.itvdnstudyspringmvc2.validation.BookUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Validated
@Slf4j
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getBooks() {
        var books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @Async
    @GetMapping("/async")
    public CompletableFuture<String> getBookstoreName() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Future1");
            return "Future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Future2");
            return "Future2";
        });
        CompletableFuture<String> combinedFuture = future1
                .thenCombine(future2, (res1, res2) -> {
            log.info("Combined");
            return "Result: " + res1 + " and " + res2;
        });
        return combinedFuture;
    }
    @Async
    @GetMapping("/bookstore-name")
    public CompletableFuture<String> getBookstore() {
        log.info(Thread.currentThread().getName());
        return CompletableFuture.completedFuture("BookStore1");
    }

    @Async
    @GetMapping("/bookstore-id")
    public CompletableFuture<Integer> getBookstoreId() {
        log.info(Thread.currentThread().getName());
        return CompletableFuture.completedFuture(1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        var book = bookService.getBook(id).orElseThrow();
        return ResponseEntity.ok(book);
    }

    @Validated({BookCreate.class})
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid BookDTO bookDTO) {
        bookService.save(bookDTO);
        return ResponseEntity.ok().build();
    }

    @Validated({BookUpdate.class})
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) {
        bookDTO.setId(id);
        bookService.update(bookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
