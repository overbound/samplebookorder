package com.brycestock.bookstoreapi;

import com.brycestock.bookstoreapi.order.dao.OrderDAO;
import com.brycestock.bookstoreapi.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void persistOrder(Order order) throws Exception {
        long id = orderDAO.persistOrder(order);

        if(id > 0) {
            order.getBooks().forEach( book -> {
                book.setOrderId(id);
            });
            orderDAO.insertOrderBook(order.getBooks());
            return;
        }
        throw new Exception("Unable to persist order");
    }
}
