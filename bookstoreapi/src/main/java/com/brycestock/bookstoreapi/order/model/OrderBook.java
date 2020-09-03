package com.brycestock.bookstoreapi.order.model;

import java.math.BigDecimal;

public class OrderBook {
    long bookId;
    long orderId;
    String name;
    String author;
    int quantity;
    BigDecimal price;
    int quantityToPurchase;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantityToPurchase() {
        return quantityToPurchase;
    }

    public void setQuantityToPurchase(int quantityToPurchase) {
        this.quantityToPurchase = quantityToPurchase;
    }
}
