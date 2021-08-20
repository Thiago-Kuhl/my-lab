package com.tk.thenewbank.models

data class Bank(
    val accountNumber: String,
    val trust: Double,
    val transactionFee: Int
)