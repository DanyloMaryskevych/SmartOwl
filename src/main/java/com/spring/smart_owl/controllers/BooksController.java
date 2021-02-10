package com.spring.smart_owl.controllers;

import com.spring.smart_owl.dao.BookDAO;
import com.spring.smart_owl.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Optional;

@Controller
@RequestMapping("/smart_owl")
public class BooksController {

    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(@RequestParam Optional<String> sort,
                        @RequestParam Optional<String> order, Model model) {
        model.addAttribute("books", bookDAO.index(sort.orElseGet(() -> "id"), order.orElseGet(() -> "asc")));
        return "books/hello_page";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String addBook(@ModelAttribute("book") @Valid Book book,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/new";
        bookDAO.save(book);
        return "redirect:/smart_owl";
    }
}