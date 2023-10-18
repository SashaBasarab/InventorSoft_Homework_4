package com.example.inventorsoft_homework_4.service.impl;

import com.example.inventorsoft_homework_4.entity.Book;
import com.example.inventorsoft_homework_4.exception.BookNotFoundException;
import com.example.inventorsoft_homework_4.exception.UserNotFoundException;
import com.example.inventorsoft_homework_4.repository.BookRepository;
import com.example.inventorsoft_homework_4.repository.UserRepository;
import com.example.inventorsoft_homework_4.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private UserRepository userRepository;

    @Override
    public void addBook(Book book, Long userId) {
        book.setUser(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " is not found")));
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).orElseThrow(() -> new BookNotFoundException("Book with id " + book.getId() + " is not found"));
        book.setUser(existingBook.getUser());
        if (existingBook.equals(book)) {
            return;
        } else {
            bookRepository.save(book);
        }
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> getAllBooksByUser(Long userId) {
        return bookRepository.findAllByUser(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " is not found")));
    }

    @Override
    public List<Book> getAllBySomeInfo(String info) {
        return bookRepository.findAllByAuthorOrName(info, info);
    }
}
