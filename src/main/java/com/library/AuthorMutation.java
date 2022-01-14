package com.library;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {
    @Autowired
    private AuthorService authorService;
    public Author saveAuthor(final String name, final String title) {
        return this.authorService.saveAuthor(name, title);
    }
}