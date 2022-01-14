package com.library;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookService(final BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository ;
        this.authorRepository = authorRepository;
    }
    @Transactional
    public Book saveBook(final String title, final String authorName) {
        Author author = authorRepository.findAll().stream().filter(a -> a.getName().equals(authorName)).findFirst().orElse(new Author());
        if (author.getName() == null) {
            author.setName(authorName);
        }
        Book book = author.getBooks().stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(new Book());
        if (book.getTitle() == null) {
            book.setTitle(title);
        }
        book.setAuthor(author);
        authorRepository.save(author);
        return this.bookRepository.save(book);
    }
    @Transactional(readOnly = true)
    public List<Book> allBooks() {
        return new ArrayList<>(this.bookRepository.findAll());
    }
    @Transactional(readOnly = true)
    public List<Book> getBooksByAuthor(String authorName) {
        return this.bookRepository.findAll().stream().filter(book -> book.getAuthor().getName().equals(authorName)).collect(Collectors.toList());
    }
}
