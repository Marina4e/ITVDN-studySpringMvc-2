package org.mvc.itvdnstudyspringmvc2.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mvc.itvdnstudyspringmvc2.dto.BookDTO;
import org.mvc.itvdnstudyspringmvc2.services.BookService;
import org.mvc.itvdnstudyspringmvc2.validation.BookCreate;
import org.mvc.itvdnstudyspringmvc2.validation.BookUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String getBooks(Model model) {
        var books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        var book = bookService.getBook(id).orElseThrow();
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create";
    }

    @Validated({BookCreate.class})
    @PostMapping("/create")
    public String create(@ModelAttribute("bookDto") @Valid BookDTO bookDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        bookService.save(bookDTO);
        return "redirect:/book/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        var book = bookService.getBook(id).orElseThrow();
        model.addAttribute("bookToUpdate", book);
        return "update";
    }

    @Validated({BookUpdate.class})
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("bookToUpdate")
    @Valid BookDTO bookDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        bookDTO.setId(id);
        bookService.update(bookDTO);
        return "redirect:/book/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/book/all";
    }

    @ModelAttribute("bookDto")
    public BookDTO bookDTO() {
        return new BookDTO();
    }
}
