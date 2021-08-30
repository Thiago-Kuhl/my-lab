package com.tk.thenewbank.datasource.network.dto

import com.tk.thenewbank.models.Bank

data class BankList(
    val results: Collection<Bank>
)