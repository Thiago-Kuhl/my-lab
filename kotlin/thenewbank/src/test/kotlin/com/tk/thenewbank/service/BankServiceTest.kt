package com.tk.thenewbank.service

import com.tk.thenewbank.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {
    private val datasource: BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(datasource)

    @Test
    fun `should call its data source to retrieve banks`() {
        //when
        bankService.getBanks()

        //then
        verify(exactly = 1) { datasource.retrieveBanks() }
    }
}