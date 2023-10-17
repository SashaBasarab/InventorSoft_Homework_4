package com.example.inventorsoft_homework_4.repository;

import com.example.inventorsoft_homework_4.entity.Book;
import com.example.inventorsoft_homework_4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByUser(User user);
    List<Book> findAllByAuthorOrName(String info);
}
