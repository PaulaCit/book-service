package com.example.bookservice.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.Date
@Entity(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "author", nullable = false, length = 180)
    var author: String = "",

    @Column(name = "launch_date", nullable = false)
    var lauchDate: Date? = null,

    @Column(name = "price", nullable = false)
    var price: Double? = null,

    @Column(name = "title", nullable = false, length = 250)
    var title: String = "",

    @Transient
    var currency: String? = "",

    @Transient
    var environment: String? = "",
)