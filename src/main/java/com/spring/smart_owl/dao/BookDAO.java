package com.spring.smart_owl.dao;

import com.spring.smart_owl.models.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDAO {

    public static final String DBNAME = "smart_owl";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + DBNAME;
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "1111";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> index() {
        List<Book> books = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM books";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAmount(resultSet.getInt("amount"));
                book.setYear(resultSet.getInt("year"));
                book.setAuthor(resultSet.getString("author"));

                books.add(book);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}
