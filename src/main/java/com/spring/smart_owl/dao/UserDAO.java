package com.spring.smart_owl.dao;

import com.spring.smart_owl.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void newUser(User user) {
        jdbcTemplate.update("INSERT INTO users(first_name, last_name, email, password) values(?, ?, ?, ?)",
                user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword());
    }

}
