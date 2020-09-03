package com.brycestock.bookstoreapi.book.model;

import java.math.BigDecimal;

public class Book {
    long bookId;
    String name;
    String author;
    int quantity;
    BigDecimal price;

    public Book(long bookId, String name, String author, int quantity, BigDecimal price) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
