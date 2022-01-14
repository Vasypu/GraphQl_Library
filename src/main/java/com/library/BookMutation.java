package com.library;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    private BookService bookService;
    public Book saveBook(final String title, final String authorName) {
        return this.bookService.saveBook(title, authorName);
    }
}