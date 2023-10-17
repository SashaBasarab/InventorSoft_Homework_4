package com.example.inventorsoft_homework_4.service;

import com.example.inventorsoft_homework_4.entity.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book, Long userId);

    void updateBook(Book book);

    void deleteBook(Long bookId);

    List<Book> getAllBooksByUser(Long userId);

    List<Book> getAllBySomeInfo(String info);

}
