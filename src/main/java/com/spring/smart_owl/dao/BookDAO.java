package com.spring.smart_owl.dao;

import com.spring.smart_owl.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(String sortOrder, String order) {
        return jdbcTemplate.query("SELECT * FROM books ORDER BY " + sortOrder + " " + order, new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books(title, image, description, price, amount, year, author) values(?, ?, ?, ?, ?, ?, ?)",
                book.getTitle(), book.getImage(), book.getDescription(), book.getPrice(),
                book.getAmount(), book.getYear(), book.getAuthor());
    }
}
