package com.currency.quote.configuration

import com.currency.quote.gateway.TelegramClient
import feign.Feign
import feign.jackson.JacksonDecoder

class TelegramClientConfig(
    val baseUrl: String = System.getenv("TELEGRAM_BASE_URL")
) {

    fun builder(): TelegramClient {
        return Feign.builder()
            .decoder(JacksonDecoder())
            .target(TelegramClient::class.java, baseUrl)

    }

}