package com.brycestock.bookstoreapi.book;

import com.brycestock.bookstoreapi.book.dao.BookDAO;
import com.brycestock.bookstoreapi.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    BookDAO bookDAO;

    @Autowired
    BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllbooks() {
        return bookDAO.getAllBooks();
    }

    public Book persistBook(Book book) throws Exception {
       long bookId = bookDAO.persistBook(book);

       if(bookId > 0) {
           return bookDAO.getBook(bookId);
       }
       throw new Exception("Unable to save book");
    }
}
