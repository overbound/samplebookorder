package com.brycestock.bookstoreapi.book.dao;

import com.brycestock.bookstoreapi.book.dao.mapper.BookMapper;
import com.brycestock.bookstoreapi.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.brycestock.bookstoreapi.config.DatabaseConfig.NAMEDJDBCTEMPLATE;

@Repository
public class BookDAO {

    @Autowired
    @Qualifier(NAMEDJDBCTEMPLATE)
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks() {
        String sql = "SELECT id, name, author, quantity, price" +
                " FROM bookstore.books;";

        return jdbcTemplate.query(sql, new BookMapper());
    }

    public long persistBook(Book book) {
        String sql = "INSERT INTO bookstore.books(" +
                " name, author, quantity, price)" +
                " VALUES ( :name, :author, :quantity, :price);";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", book.getName());
        params.addValue("author", book.getAuthor());
        params.addValue("quantity", book.getQuantity());
        params.addValue("price", book.getPrice());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, params, keyHolder, new String[] { "id" });
        return keyHolder.getKey().longValue();
    }

    public Book getBook(long id) {
        String sql = "SELECT id, name, author, quantity, price" +
                " FROM bookstore.books where id = :id;";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(sql, params, new BookMapper()).get(0);
    }
}
