package com.brycestock.bookstoreapi.book.dao.mapper;

import com.brycestock.bookstoreapi.book.model.Book;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getLong("id"),rs.getString("name"), rs.getString("author"), rs.getInt("quantity"), rs.getBigDecimal("price"));
    }
}
