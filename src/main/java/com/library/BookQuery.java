package com.library;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;

    public List<Book> getAllBooks() {
        return this.bookService.allBooks();
    }

    public List<Book> getBooksByAuthor(final String authorName) {
        return this.bookService.getBooksByAuthor(authorName);
    }
}
