package com.letter.service.impl;

import com.letter.entity.Books;
import com.letter.repository.BookRepository;
import com.letter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Books> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public List<Books> findAllByIds(List ids) {
        return bookRepository.findAllById(ids);
    }

    @Override
    public Books findBooksById(String id) {
        return bookRepository.findBooksById(id);
    }

    @Override
    public Books findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    @Override
    public Books findBooksByAuthorIs(String author) {
        return bookRepository.findBooksByAuthorIs(author);
    }

    @Override
    public Books findBooksByIbsn(String ibsn) {
        return bookRepository.findBooksByIbsn(ibsn);
    }

    @Override
    public List<Books> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public void addBook(Books book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Books book) {
        bookRepository.saveAndFlush(book);
    }
}
