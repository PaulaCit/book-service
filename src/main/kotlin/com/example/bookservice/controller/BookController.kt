package com.example.bookservice.controller

import com.example.bookservice.model.Book
import com.example.bookservice.proxy.CambioProxy
import com.example.bookservice.repository.BookRepository
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book-service")
class BookController(
    private var environment: Environment,
    private var repository: BookRepository,
    private var proxy: CambioProxy
) {

    @GetMapping("/{id}/{currency}")
    fun findBook(
        @PathVariable("id") id: Long,
        @PathVariable("currency") currency: String?
    ): Book{
        val book = repository.findById(id).orElseThrow{ RuntimeException("Book not found") }
        val port = environment.getProperty("local.server.port")

        val cambio = proxy.getCambio(book.price, "USD", currency)


        book.environment = "$port FEIGN"
        book.currency = currency
        return book
    }
}