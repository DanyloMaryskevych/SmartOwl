package com.spring.smart_owl.controllers;

import com.spring.smart_owl.dao.BookDAO;
import com.spring.smart_owl.dao.UserDAO;
import com.spring.smart_owl.models.Book;
import com.spring.smart_owl.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @PostMapping("/login")
    public String newUser(@ModelAttribute("user") User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/hello_page";
        userDAO.newUser(user);
        return "redirect:/smart_owl";
    }


}
