package com.spring.smart_owl.controllers;

import com.spring.smart_owl.dao.BookDAO;
import com.spring.smart_owl.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/smart_owl")
public class BooksController {

    private final BookDAO bookDAO;

    @Autowired
    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("books", bookDAO.index());
        return "books/hello_page";
    }
}