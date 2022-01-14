package com.library;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
    @Autowired
    private AuthorService authorService;

    public Optional<Author> getAuthor(String name) {
        return this.authorService.getAuthor(name);
    }
}