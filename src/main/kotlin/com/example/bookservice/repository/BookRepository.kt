package com.example.bookservice.repository

import com.example.bookservice.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>