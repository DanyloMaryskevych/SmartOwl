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
import java.util.List;
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

    @GetMapping("/{id}")
    public String showBook(@PathVariable int id, Model model) {
        model.addAttribute("someBook", bookDAO.getBook(id));
        return "books/show";
    }

    @PostMapping()
    public String addBook(@ModelAttribute("book") @Valid Book book,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/new";
        bookDAO.save(book);
        return "redirect:/smart_owl";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("someBook", bookDAO.getBook(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String editBook(@ModelAttribute("someBook") @Valid Book book,
                           BindingResult bindingResult,
                           @PathVariable int id) {
        if (bindingResult.hasErrors()) return "books/edit";

        bookDAO.editBook(id, book);
        return "redirect:/smart_owl";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        bookDAO.delete(id);
        return "redirect:/smart_owl";
    }
}