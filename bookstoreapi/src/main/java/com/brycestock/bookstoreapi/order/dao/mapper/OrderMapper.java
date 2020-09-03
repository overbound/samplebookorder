package com.brycestock.bookstoreapi.order.dao.mapper;

import com.brycestock.bookstoreapi.order.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(rs.getLong("id"), rs.getLong("customer_id"));
    }
}
