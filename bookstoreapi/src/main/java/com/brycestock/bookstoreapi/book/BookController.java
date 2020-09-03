package com.brycestock.bookstoreapi.book;

import com.brycestock.bookstoreapi.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.brycestock.bookstoreapi.book.model.Book;

@RestController("book")
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllbooks();
    }

    @PostMapping
    public Book persistBook(@RequestBody Book book) throws Exception {
        return bookService.persistBook(book);
    }
}
