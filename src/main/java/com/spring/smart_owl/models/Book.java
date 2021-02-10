package com.spring.smart_owl.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty(message = "Title shouldn't be empty!")
    @Size(min = 2, message = "Too short title!")
    private String title;

    @NotEmpty(message = "Image shouldn't be empty!")
    private String image;

    private String description;

    @Min(value = 1, message = "Price shouldn't be less than 1$!")
    private double price;

    @Min(value = 0, message = "Amount shouldn't be less than 0!")
    private int amount;

    @Min(value = 1000, message = "Year shouldn't be empty!")
    private int year;

    @NotEmpty(message = "Author shouldn't be empty!")
    private String author;

    public Book() {
    }
//    create table books(
//            id serial primary key,
//            title varchar,
//            image varchar,
//            description varchar,
//            price double precision,
//            amount int,
//            year int,
//            author varchar
//    )
//    1,1984,3.55,12,1949,George Orwell
//2,The Great Gatsby,5.8,23,1925,F. Scott Fitzgerald
//3,Animal Farm,4.6,35,1945,George Orwell
//4,New Book,5.6,14,2015,Maris
//5,An American Tragedy,9.5,15,1925,Theodore Dreiser


    public Book(String title, double price, int amount, int year, String author) {
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.year = year;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
