package com.tk.thenewbank.service

import com.tk.thenewbank.datasource.BankDataSource
import com.tk.thenewbank.models.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank {
        return dataSource.retrieveBank(accountNumber)
    }


}