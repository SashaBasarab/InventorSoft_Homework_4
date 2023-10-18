package com.example.inventorsoft_homework_4.controller;

import com.example.inventorsoft_homework_4.entity.Book;
import com.example.inventorsoft_homework_4.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book-management")
@Slf4j
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PostMapping("/add-book")
    public void addNewBook(@RequestBody @Valid Book book, @RequestParam Long userId) {
        log.info("Request: book {} and userId {}", book, userId);
        bookService.addBook(book, userId);
    }

    @PutMapping("/update-book")
    public void updateBook(@RequestBody @Valid Book book) {
        log.info("Request: book {}", book);
        bookService.updateBook(book);
    }

    @DeleteMapping("/delete-book")
    public void deleteBook(@RequestParam Long bookId) {
        log.info("Request: bookId: {}", bookId);
        bookService.deleteBook(bookId);
    }

    @GetMapping("/get-all-books")
    public List<Book> getAllBooksByUser(@RequestParam Long userId) {
        log.info("Request: userId {}", userId);
        return bookService.getAllBooksByUser(userId);
    }

    @GetMapping("/get-books-by-info")
    public List<Book> getAllBooksByInfo(@RequestParam String info) {
        log.info("Request: info {}", info);
        return bookService.getAllBySomeInfo(info);
    }
}
