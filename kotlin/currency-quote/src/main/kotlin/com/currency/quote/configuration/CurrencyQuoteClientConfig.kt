package com.currency.quote.configuration

import com.currency.quote.gateway.CurrencyQuoteClient
import feign.Feign
import feign.jackson.JacksonDecoder

class CurrencyQuoteClientConfig(
    val baseUrl: String = System.getenv("CURRENCY_BASE_URL")
) {

    fun builder(): CurrencyQuoteClient {
        return Feign.builder()
            .decoder(JacksonDecoder())
            .target(CurrencyQuoteClient::class.java, baseUrl)

    }

}