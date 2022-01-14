package com.library;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    public AuthorService(final AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Transactional
    public Author saveAuthor(final String authorName, final String title) {
        Author author = authorRepository.findAll().stream().filter(a -> a.getName().equals(authorName)).findFirst().orElse(new Author());
        if (author.getName() == null) {
            author.setName(authorName);
        }
        Book book = author.getBooks().stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(new Book());
        if (book.getTitle() == null) {
            book.setTitle(title);
        }
        book.setAuthor(author);
        bookRepository.save(book);
        return this.authorRepository.save(author);
    }
    @Transactional(readOnly = true)
    public Optional<Author> getAuthor(String name) {
        return this.authorRepository.findAll().stream().filter(author -> author.getName().equals(name)).findFirst();
    }
}
