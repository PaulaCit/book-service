package com.example.bookservice.model

import java.util.Date

data class Book(
    var id: Long = 0,
    var author: String = "",
    var lauchDate: Date? = null,
    var price: Double? = null,
    var title: String = "",
    var currency: String? = "",
    var environment: String? = "",
)