package com.brycestock.bookstoreapi.order.dao;

import com.brycestock.bookstoreapi.book.model.Book;
import com.brycestock.bookstoreapi.order.dao.mapper.OrderMapper;
import com.brycestock.bookstoreapi.order.model.Order;
import com.brycestock.bookstoreapi.order.model.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.brycestock.bookstoreapi.config.DatabaseConfig.NAMEDJDBCTEMPLATE;

@Repository
public class OrderDAO {

    @Autowired
    @Qualifier(NAMEDJDBCTEMPLATE)
    NamedParameterJdbcTemplate jdbcTemplate;

    public long persistOrder(Order order) {
        String sql = "INSERT INTO bookstore.order(customer_id)" +
                " VALUES ( :customerId);";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("customerId", order.getCustomerId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder, new String[] { "id" });
        return keyHolder.getKey().longValue();
    }

    public int insertOrderBook(List<OrderBook> book){
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(book.toArray());
        String sql = "INSERT INTO bookstore.order_book(order_id, book_id, order_quantity)" +
                " VALUES (:orderId, :bookId, :quantityToPurchase);";

        int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);
        return updateCounts.length;
    }
}
