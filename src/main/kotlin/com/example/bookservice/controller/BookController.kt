package com.example.bookservice.controller

import com.example.bookservice.model.Book
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
@RequestMapping("book-service")
class BookController(
    private var environment: Environment
) {

    @GetMapping("/{id}/{currency}")
    fun findBook(
        @PathVariable("id") id: Long?,
        @PathVariable("currency") currency: String?
    ): Book{
        val port = environment.getProperty("local.server.port")
        return Book(
            id = 1L,
            author = "Nigel Poulton",
            title = "Docker Deep Dive",
            lauchDate = Date(),
            price = 15.8.toDouble(),
            currency = currency,
            environment = port

        )
    }
}