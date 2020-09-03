package com.brycestock.bookstoreapi.order;

import com.brycestock.bookstoreapi.OrderService;
import com.brycestock.bookstoreapi.book.BookService;
import com.brycestock.bookstoreapi.book.model.Book;
import com.brycestock.bookstoreapi.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void persistOrder(@RequestBody Order order) throws Exception {
        orderService.persistOrder(order);
    }
}
