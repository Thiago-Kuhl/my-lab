package com.tk.thenewbank.datasource

import com.tk.thenewbank.models.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
}