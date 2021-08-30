package com.tk.thenewbank.datasource.mock

import com.tk.thenewbank.datasource.BankDataSource
import com.tk.thenewbank.models.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1234", 1.0, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists.")
        } else {
            banks.add(bank)
        }

        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank =
            banks.firstOrNull() { it.accountNumber == bank.accountNumber }
                ?: throw NoSuchElementException("Bank with account number ${bank.accountNumber} not exists.")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountNumber: String): Unit {
        val currentBank = banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

        banks.remove(currentBank)

    }


}