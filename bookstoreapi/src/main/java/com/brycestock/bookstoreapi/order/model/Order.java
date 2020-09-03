package com.brycestock.bookstoreapi.order.model;

import com.brycestock.bookstoreapi.book.model.Book;

import java.util.List;

public class Order {
    long id;
    List<OrderBook> books;
    long customerId;

    public Order(long id, long customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderBook> getBooks() {
        return books;
    }

    public void setBooks(List<OrderBook> books) {
        this.books = books;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
