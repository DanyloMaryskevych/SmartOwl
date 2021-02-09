package com.spring.smart_owl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/smart_owl")
public class BooksController {

    @GetMapping()
    public String hello() {
        return "books/hello_page";
    }
}
