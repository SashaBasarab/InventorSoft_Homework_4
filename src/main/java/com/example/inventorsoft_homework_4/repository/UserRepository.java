package com.example.inventorsoft_homework_4.repository;

import com.example.inventorsoft_homework_4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
