package com.letter.service;

import com.letter.entity.Books;

import java.util.List;

public interface BookService {
    List<Books> findAll();

    List<Books> findAllByIds(List ids);

    Books findBooksById(String id);

    Books findBooksByTitle(String title);

    Books findBooksByAuthorIs(String author);

    Books findBooksByIbsn(String ibsn);

    List<Books> findBooksByAuthor(String author);

    void addBook(Books book);

    void deleteById(String id);

    void updateBook(Books book);


}
