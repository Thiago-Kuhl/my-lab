package com.currency.quote.gateway

import com.currency.quote.DolarCurrencyResponse
import com.currency.quote.EuroCurrencyResponse
import feign.RequestLine

interface CurrencyQuoteClient {

    @RequestLine("GET /json/last/USD-BRL")
    fun getDolarRate(): DolarCurrencyResponse

    @RequestLine("GET /json/last/EUR-BRL")
    fun getEuroRate(): EuroCurrencyResponse
}