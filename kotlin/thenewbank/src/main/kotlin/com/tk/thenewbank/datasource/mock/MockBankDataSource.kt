package com.tk.thenewbank.datasource.mock

import com.tk.thenewbank.datasource.BankDataSource
import com.tk.thenewbank.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = listOf(
        Bank("1234", 1.0, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

}